package com.kingdee.exam.voj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 程序测试点的Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_problem_checkpoints")
public class Checkpoint implements Serializable {
	public Checkpoint(long problemId, int checkpointId, boolean isExactlyMatch, int score, String input, String output) {
		this.problemId = problemId;
		this.checkpointId = checkpointId;
		this.isExactlyMatch = isExactlyMatch;
		this.score = score;
		this.input = input;
		this.output = output;
	}

    @Id
	private int checkpointId;

    /**
     * 试题的id
     */
    @Id
    private long problemId;
	/**
	 * 是否精确匹配测试点.
	 */
	@Column(name = "checkpoint_exactly_match")
	private boolean isExactlyMatch;
	
	/**
	 * 测试点分值.
	 */
    @Column(name = "checkpoint_score")
	private int score;
	
	/**
	 * 测试点的标准输入.
	 */
    @Column(name = "checkpoint_input",columnDefinition = "longtext")
	private String input;
	
	/**
	 * 测试点的标准输出.
	 */
    @Column(name = "checkpoint_output",columnDefinition = "longtext")
	private String output;
	
	@Transient
	private static final long serialVersionUID = -8129670699537187948L;
}
