package com.kingdee.exam.util;

import com.kingdee.exam.dao.ExamMapper;
import com.kingdee.exam.dao.ScoreMapper;
import com.kingdee.exam.dao.TestPaperMapper;
import com.kingdee.exam.entity.Score;
import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.Times;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 */
@Component
public class ExamTask {

	@Resource
	private ExamMapper examMapper;
	@Resource
	private ScoreMapper scoreMapper;
	@Resource
	private TestPaperMapper testPaperMapper;

	/**
	 * 检测考试时间，60秒执行一次
	 */
    @Scheduled(cron="*/60 * * * * ?")
	public void updateTestPaperStatus() {
		//获取所有有效试卷
		List<TestPaper> allTestPaper = testPaperMapper.findTestPaperInfo();
		for (TestPaper testPaper : allTestPaper) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date startDate=new Date();
            Date endDate=new Date();
            try {
                endDate = sdf.parse(testPaper.getEndDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
			if ((new Date().getTime()>endDate.getTime() || new Date().getTime()<startDate.getTime())
                    && testPaper.getIsStart()==1) {
                new Timer().schedule(new TimerTask() {
                    public void run() {
                        testPaper.setIsStart(0);
                        testPaperMapper.updateIsStart(testPaper);
                    }
                }, 5000);//等5秒钟再禁用试卷，避免有同学正在提交试卷
			}else if (new Date().getTime()<endDate.getTime() && new Date().getTime()>startDate.getTime()
                    && testPaper.getIsStart()==0) {
                new Timer().schedule(new TimerTask() {
                    public void run() {
                        testPaper.setIsStart(1);
                        testPaperMapper.updateIsStart(testPaper);
                    }
                }, 5000);//等5秒钟再禁用试卷，避免有同学正在提交试卷
            }

		}
	}

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
                new Timer().schedule(new TimerTask() {
                    public void run() {
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
                    }
                }, 5000);//等5秒钟再查成绩，避免有同学正在提交试卷

				//更新考试时间无效
				times.setTimesState(0);
				examMapper.updateExamTimes(times);
			}
		}
	}
}
