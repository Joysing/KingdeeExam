package com.kingdee.exam.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;


/**
 * HTML文本过滤组件.
 */
public class HtmlTextFilter {
	/**
	 * Utility classes should not have a public constructor.
	 */
	private HtmlTextFilter() { }
	
	/**
	 * 过滤包含HTML字符串.
	 * @param text - 待过滤的字符串
	 * @return 过滤后的字符串.
	 */
	public static String filter(String text) {
		if ( text == null ) {
			return text;
		}
		
		Document document = Jsoup.parse(text);
		document.outputSettings(new Document.OutputSettings().prettyPrint(false));
		document.select("br").append("\\n");
		document.select("p").prepend("\\n\\n");
		String s = document.html().replaceAll("\\\\n", "\n");
		return Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
	}
}
