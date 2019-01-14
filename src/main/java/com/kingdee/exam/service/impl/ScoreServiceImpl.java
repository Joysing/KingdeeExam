package com.kingdee.exam.service.impl;

import com.kingdee.exam.dao.ScoreMapper;
import com.kingdee.exam.entity.vo.scoreVo;
import com.kingdee.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreMapper scoreMapper;
	@Override
	public List<scoreVo> findUserExamInfo() {
		return scoreMapper.findUserExamInfo();
	}

}
