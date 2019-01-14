package com.kingdee.exam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "testpaper")
public class TestPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testpaper_id")
	private Integer testpaperId;

    @Column(name = "testpaper_name")
	private String testpaperName;

    @Column(name = "testpaper_state")
	private Integer testpaperState;

    @Column(name = "start_date")
	private String startDate;

    @Column(name = "end_date")
	private String endDate;

    @Column(name = "is_start")
	private Integer isStart;

}