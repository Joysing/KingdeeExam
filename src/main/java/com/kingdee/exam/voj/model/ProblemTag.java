package com.kingdee.exam.voj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 试题标签的 Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_problem_tags")
public class ProblemTag implements Serializable {

	public ProblemTag(String problemTagSlug, String problemTagName) {
		this.problemTagSlug = problemTagSlug;
		this.problemTagName = problemTagName;
	}
	
	public ProblemTag(long problemTagId, String problemTagSlug, String problemTagName) {
		this(problemTagSlug, problemTagName);
		this.problemTagId = problemTagId;
	}
	
	public int hashCode() {
		return (int) problemTagId;
	}
	public boolean equals(Object obj) {
		if ( obj instanceof ProblemTag ) {
			ProblemTag anotherTag = (ProblemTag)obj;
			return anotherTag.getProblemTagId() == problemTagId;
		}
		return false;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long problemTagId;
	
	/**
	 * 试题标签的别名.
	 */
	private String problemTagSlug;
	
	/**
	 * 试题标签的名称.
	 */
	private String problemTagName;
	
	@Transient
	private static final long serialVersionUID = 1636220984815816993L;
}
