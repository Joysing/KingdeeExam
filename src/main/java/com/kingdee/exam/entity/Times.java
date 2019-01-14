package com.kingdee.exam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "times")
public class Times {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times_id")
    private Integer timesId;

    @Column(name = "testpaper_id")
    private Integer testpaperId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "data_min")
    private Double dataMin;

    @Column(name = "data_seconds")
    private Double dataSeconds;

    @Column(name = "times_state")
    private Integer timesState;

}