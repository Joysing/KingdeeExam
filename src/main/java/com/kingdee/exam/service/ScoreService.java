package com.kingdee.exam.service;

import com.kingdee.exam.entity.vo.scoreVo;
import java.util.List;

public interface ScoreService {
    //查询所有考生成绩信息
    List<scoreVo> findUserExamInfo();

}
