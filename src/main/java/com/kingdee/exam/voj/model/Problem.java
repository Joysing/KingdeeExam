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
        this.inputSample = sampleInput;
        this.outputSample = sampleOutput;
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
    private int timeLimit;

    /**
     * 最大运行内存.
     */
    private int memoryLimit;

    /**
     * 试题描述.
     */
    @Column(name = "description",columnDefinition = "text")
    private String description;

    /**
     * 输入格式.
     */
    @Column(name = "input_format",columnDefinition = "text")
    private String inputFormat;

    /**
     * 输出格式.
     */
    @Column(name = "output_format",columnDefinition = "text")
    private String outputFormat;

    /**
     * 样例输入.
     */
    @Column(name = "sample_input",columnDefinition = "text")
    private String inputSample;

    /**
     * 样例输出.
     */
    @Column(name = "sample_output",columnDefinition = "text")
    private String outputSample;

    /**
     * 试题提示.
     */
    @Column(name = "hint",columnDefinition = "text")
    private String hint;

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
