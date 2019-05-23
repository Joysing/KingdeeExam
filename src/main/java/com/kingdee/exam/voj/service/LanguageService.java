package com.kingdee.exam.voj.service;

import com.kingdee.exam.voj.mapper.LanguageMapper;
import com.kingdee.exam.voj.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 编程语言类(Language)的业务逻辑层.
 */
@Service
@Transactional
public class LanguageService {
	/**
	 * 获取支持的编程语言.
	 * @return 编程语言列表(List<Language>对象)
	 */
	public List<Language> getAllLanguages() {
		return languageMapper.getAllLanguages();
	}

	@Autowired
	private LanguageMapper languageMapper;

}
