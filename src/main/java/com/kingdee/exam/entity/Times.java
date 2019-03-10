package com.kingdee.exam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "times")
public class Times {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timesId;

    private Integer testpaperId;

    private Integer userId;

    private Date startTime;

    private Integer timesState;

}