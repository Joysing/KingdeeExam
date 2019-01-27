package com.kingdee.exam.util;

import com.kingdee.exam.dao.ExamMapper;
import com.kingdee.exam.dao.ScoreMapper;
import com.kingdee.exam.entity.Score;
import com.kingdee.exam.entity.Times;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * 定时器
 */
@Component
public class ExamTask {

	@Resource
	private ExamMapper examMapper;
	@Resource
	private ScoreMapper scoreMapper;
	
	/**
	 * 检测考试时间，60秒执行一次
	 */
    @Scheduled(cron="*/60 * * * * ?")
	public void updateTime() {
		//所有用户时间
		List<Times> allExamTimes = examMapper.findAllExamTimes();
		for (Times times : allExamTimes) {
            long seconds=60*60*1000-(new Date().getTime()-times.getStartTime().getTime());
			 //时间到。如果没成绩设置0分
			if (seconds<0) {
                try {
                    //等5秒钟再查成绩，避免有同学正在提交试卷
                    Robot robot = new Robot();
                    robot.delay(5000);
                } catch (AWTException e) {
                    e.printStackTrace();
                }

				Score score = new Score();
				score.setUsersId(times.getUserId());
				score.setTestpaperId(times.getTestpaperId());
				Score ifExistenceScore = examMapper.findIfExistenceScore(score);
				if (ifExistenceScore == null) {//如果空 设置成绩0分
					Score record = new Score();
					record.setTestpaperId(times.getTestpaperId());
					record.setUsersId(times.getUserId());
					record.setFraction(0.0);
					scoreMapper.insertSelective(record);
				}
				//更新考试时间无效
				times.setTimesState(0);
				examMapper.updateExamTimes(times);
			}
		}
	}
}
