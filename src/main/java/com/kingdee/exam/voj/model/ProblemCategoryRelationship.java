package com.kingdee.exam.voj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 试题分类关系的 Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_problem_category_relationships")
public class ProblemCategoryRelationship implements Serializable {

	public int hashCode() {
		return (int) problemId + problemCategoryId;
	}
	
	public boolean equals(Object obj) {
		if ( obj instanceof ProblemCategoryRelationship ) {
			ProblemCategoryRelationship anotherCategoryRelationship = (ProblemCategoryRelationship)obj;
			return anotherCategoryRelationship.getProblemId() == problemId && 
				anotherCategoryRelationship.getProblemCategoryId() == problemCategoryId;
		}
		return false;
	}

	/**
	 * 试题的id
	 */
    @Id
	private long problemId;

	/**
	 * 试题分类的id
	 */
    @Id
	private int problemCategoryId;
	
	/**
	 * 试题分类的别名.
	 */
	@Transient
	private String problemCategorySlug;
	
	/**
	 * 试题分类的名称.
	 */
    @Transient
	private String problemCategoryName;
}
