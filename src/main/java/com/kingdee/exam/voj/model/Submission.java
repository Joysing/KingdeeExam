package com.kingdee.exam.voj.model;

import com.kingdee.exam.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 评测记录的Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_submissions")
public class Submission implements Serializable {
	public Submission(){

	}
	public Submission(Problem problem, User user, Language language, String code) {
		this.problem = problem;
		this.user = user;
		this.language = language;
		this.code = code;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long submissionId;
	
	/**
	 * 评测对应的试题对象.
	 */
	@ManyToOne
    @JoinColumn(name = "problem_id",columnDefinition="bigint(20) NOT NULL")
	private Problem problem;
	
	/**
	 * 评测提交者的用户对象. 
	 */
    @ManyToOne
    @JoinColumn(name = "uid",columnDefinition="bigint(20) NOT NULL")
	private User user;
	
	/**
	 * 提交所使用的语言对象.
	 */
    @ManyToOne
    @JoinColumn(name = "language_id",columnDefinition="bigint(20) NOT NULL")
	private Language language;
	
	/**
	 * 评测提交时间.
	 */
	@Column(name="submission_submit_time",columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date submitTime;
	
	/**
	 * 评测开始执行时间.
	 */
    @Column(name="submission_execute_time",columnDefinition = "timestamp")
	private Date executeTime;
	
	/**
	 * 评测运行总时间.
	 */
    @Column(name="submission_used_time")
	private long usedTime;
	
	/**
	 * 评测运行占用最大内存.
	 */
    @Column(name="submission_used_memory")
	private int usedMemory;
	
	/**
	 * 评测结果.
	 */
	@Column(name = "submission_judge_result",columnDefinition="varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'PD'")
	private JudgeResult judgeResult;
	
	/**
	 * 评测运行得分.
	 */
	@Column(name="submission_judge_score")
	private int judgeScore;
	
	/**
	 * 评测运行日志.
	 */
	@Column(name="submission_judge_log",columnDefinition = "text")
	private String judgeLog;
	
	/**
	 * 评测所执行的代码.
	 */
	@Column(name="submission_code",columnDefinition = "text")
	private String code;
}
