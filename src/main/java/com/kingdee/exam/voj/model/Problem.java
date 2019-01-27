package com.kingdee.exam.voj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 试题的Model.
 */
@Getter
@Setter
@Entity
@Table(name="voj_problems")
public class Problem implements Serializable {
    public Problem() {
    }

    public Problem(int questionBankId, String problemName, int timeLimit, int memoryLimit,
                   String description, String inputFormat, String outputFormat,
                   String sampleInput, String sampleOutput, String hint) {
        this.questionBankId=questionBankId;
        this.problemName = problemName;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.description = description;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.sampleInput = sampleInput;
        this.sampleOutput = sampleOutput;
        this.hint = hint;
    }

    public Problem(long problemId,int questionBankId, String problemName, int timeLimit,
                   int memoryLimit, String description, String inputFormat, String outputFormat,
                   String sampleInput, String sampleOutput, String hint) {
        this(questionBankId, problemName, timeLimit, memoryLimit, description, inputFormat, outputFormat, sampleInput, sampleOutput, hint);
        this.problemId = problemId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long problemId;
    @Transient
    private String testCases;
    @Transient
    private String problemCategories;
    /**
     * 试题列表中的id
     */
    private int questionBankId;

    /**
     * 试题名称.
     */
    private String problemName;

    /**
     * 最大运行时间.
     */
    @Column(name = "problem_time_limit")
    private int timeLimit;

    /**
     * 最大运行内存.
     */
    @Column(name = "problem_memory_limit")
    private int memoryLimit;

    /**
     * 试题描述.
     */
    @Column(name = "problem_description",columnDefinition = "text")
    private String description;

    /**
     * 输入格式.
     */
    @Column(name = "problem_input_format",columnDefinition = "text")
    private String inputFormat;

    /**
     * 输出格式.
     */
    @Column(name = "problem_output_format",columnDefinition = "text")
    private String outputFormat;

    /**
     * 样例输入.
     */
    @Column(name = "problem_sample_input",columnDefinition = "text")
    private String sampleInput;

    /**
     * 样例输出.
     */
    @Column(name = "problem_sample_output",columnDefinition = "text")
    private String sampleOutput;

    /**
     * 试题提示.
     */
    @Column(name = "problem_hint",columnDefinition = "text")
    private String hint;

    /**
     * 试题包含的标签.
     */
//    @Transient
//    private List<ProblemTag> problemTags;

    /**
     * 试题的总提交总数.
     */
    @Transient
    private long totalSubmission;

    /**
     * 试题的提交通过总数.
     */
    @Transient
    private long acceptedSubmission;
}
