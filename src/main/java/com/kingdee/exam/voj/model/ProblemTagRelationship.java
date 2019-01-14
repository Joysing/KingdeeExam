package com.kingdee.exam.voj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 试题标签关系的 Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_problem_tag_relationships")
public class ProblemTagRelationship implements Serializable {
	public int hashCode() {
		return (int) problemId + (int) problemTagId;
	}
	public boolean equals(Object obj) {
		if ( obj instanceof ProblemTagRelationship ) {
			ProblemTagRelationship anotherTagRelationship = (ProblemTagRelationship)obj;
			return anotherTagRelationship.getProblemId() == problemId && 
				anotherTagRelationship.getProblemTagId() == problemTagId;
		}
		return false;
	}
	
	public String toString() {
		return String.format("ProblemTagRelationship [ProblemID=%d, TagID=%d, Slug=%s, Name=%s]", 
				new Object[] { problemId, problemTagId, problemTagSlug, problemTagName });
	}

	/**
	 * 试题的唯一标识符.
	 */
	@Id
	private long problemId;

	/**
	 * 试题标签的唯一标识符.
	 */
    @Id
	private long problemTagId;
	
	/**
	 * 试题标签的别名.
	 */
	@Transient
	private String problemTagSlug;
	
	/**
	 * 试题标签的名称.
	 */
    @Transient
	private String problemTagName;

    @Transient
	private static final long serialVersionUID = -1636820984815816993L;
}
