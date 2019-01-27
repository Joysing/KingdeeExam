package com.kingdee.exam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "question_bank")
public class QuestionBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_bank_id")
    private Integer questionBankId;

    private String answer;

    /**
     * 判断题=0 选择题=1 编程题=2
     */
    @Column(name = "tests_type")
    private Integer testsType;

    private Integer state;

    private String stem;
}