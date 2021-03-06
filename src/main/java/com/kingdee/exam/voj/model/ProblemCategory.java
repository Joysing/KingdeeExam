package com.kingdee.exam.voj.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 试题分类的Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_problem_categories")
public class ProblemCategory implements Serializable {
    public ProblemCategory(){}
	public ProblemCategory(String problemCategorySlug,
			String problemCategoryName, int parentProblemCategoryId) {
		this.problemCategorySlug = problemCategorySlug;
		this.problemCategoryName = problemCategoryName;
		this.parentProblemCategoryId = parentProblemCategoryId;
	}
	
	public ProblemCategory(int problemCategoryId, String problemCategorySlug,
			String problemCategoryName, int parentProblemCategoryId) { 
		this(problemCategorySlug, problemCategoryName, parentProblemCategoryId);
		this.problemCategoryId = problemCategoryId;
	}

	public int hashCode() {
		return problemCategoryId;
	}
	
	public boolean equals(Object obj) {
		if ( obj instanceof ProblemCategory ) {
			ProblemCategory anotherCategory = (ProblemCategory)obj;
			return anotherCategory.getProblemCategoryId() == problemCategoryId;
		}
		return false;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int problemCategoryId;
	
	/**
	 * 试题分类的别名.
	 */
	private String problemCategorySlug;
	
	/**
	 * 试题分类的名称.
	 */
	private String problemCategoryName;
	
	/**
	 * 试题分类的父类.
	 */
	@Column(name = "problem_category_parent_id")
	private int parentProblemCategoryId;
}
