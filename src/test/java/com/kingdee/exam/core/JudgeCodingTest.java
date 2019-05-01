package com.kingdee.exam.core;

import com.kingdee.exam.KingdeeExamApplication;
import com.kingdee.exam.voj.messenger.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KingdeeExamApplication.class)
public class JudgeCodingTest {
    @Autowired
    private MessageSender messageSender;
    @Test
    public void createSubmissionTest(){
        Map<String, Object> mapMessage = new HashMap<>();

        mapMessage.put("event", "SubmissionCreated");
        mapMessage.put("submissionId", 1024L);

        messageSender.sendMessage(mapMessage);
    }
}
