package com.kingdee.exam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "testpaper_tests")
public class TestPaperTests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testpaper_tests_id")
    private Integer testpaperTestsId;

    @Column(name = "testpaper_id")
    private Integer testpaperId;

    @Column(name = "question_bank_id")
    private Integer questionBankId;
}