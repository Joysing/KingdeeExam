package com.kingdee.exam.voj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 编程语言的Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_languages")
public class Language implements Serializable {
	public Language() { }
	public Language(String languageSlug, String languageName, String compileCommand, String runCommand) {
		this.languageSlug = languageSlug;
		this.languageName = languageName;
		this.compileCommand = compileCommand;
		this.runCommand = runCommand;
	}
	
	public Language(int languageId, String languageSlug, String languageName, String compileCommand, String runCommand) {
		this(languageSlug, languageName, compileCommand, runCommand);
		this.languageId = languageId;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int languageId;
	
	/**
	 * 编程语言的别名.
	 */
	private String languageSlug;
	
	/**
	 * 编程语言的名称.
	 */
	private String languageName;
	
	/**
	 * 编程语言的编译命令.
	 */
	@JsonIgnore
    @Column(name="language_compile_command")
	private String compileCommand;
	
	/**
	 * 编程语言的运行命令.
	 */
	@JsonIgnore
    @Column(name="language_run_command")
	private String runCommand;

    @Transient
	private static final long serialVersionUID = 9065824880175832696L;
}
