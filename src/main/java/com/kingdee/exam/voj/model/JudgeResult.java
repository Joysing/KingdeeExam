package com.kingdee.exam.voj.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 程序评测结果的Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_judge_results")
public class JudgeResult implements Serializable {

	public JudgeResult(int judgeResultId, String judgeResultSlug, String judgeResultName) {
		this.judgeResultId = judgeResultId;
		this.judgeResultSlug = judgeResultSlug;
		this.judgeResultName = judgeResultName;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int judgeResultId;
	
	/**
	 * 评测结果的英文唯一缩写.
	 */
	private String judgeResultSlug;
	
	/**
	 * 评测结果的名称.
	 */
	private String judgeResultName;
	
	@Transient
	private static final long serialVersionUID = -1572920076997918781L;
}
