package com.kingdee.exam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer scoreId;

    @Column(name = "users_id")
    private Integer usersId;

    @Column(name = "testpaper_id")
    private Integer testpaperId;

    private Double fraction;

    private String img;

}