package com.kingdee.exam.config;

import com.kingdee.exam.voj.exception.JMSErrorHandler;
import com.kingdee.exam.voj.messenger.MessageReceiver;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

@Configuration
@EnableJms
public class MessageConfig {
    private final MessageReceiver messageReceiver;

    @Autowired
    public MessageConfig(MessageReceiver messageReceiver) {
        this.messageReceiver = messageReceiver;
    }

    @Bean
    public CachingConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setTrustAllPackages(true);//信任所有包http://activemq.apache.org/objectmessage.html
        return new CachingConnectionFactory(factory);
    }
    @Bean
    public ActiveMQQueue defaultDestination() {
        return new ActiveMQQueue("vojSubmissionTaskQueue");
    }
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate=new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestination(defaultDestination());
        return jmsTemplate;
    }
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer=new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setDestinationName("vojJudgeResultQueue");
        simpleMessageListenerContainer.setMessageListener(messageReceiver);
        simpleMessageListenerContainer.setErrorHandler(new JMSErrorHandler());
        return simpleMessageListenerContainer;
    }
}
