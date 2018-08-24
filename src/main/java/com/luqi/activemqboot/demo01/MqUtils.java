package com.luqi.activemqboot.demo01;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author LUCCI
 * @date 2018/8/24 9:31
 * @Description: 消息队列 --工具类
 * @Modify:
 */
@Component
public class MqUtils {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送队列消息模式
     * @param target
     * @param message
     */
    public void sendQueueMessage(String target, Object message){
        Queue queue = new ActiveMQQueue(target);
        jmsMessagingTemplate.convertAndSend(queue,message);
    }

    /**
     *  发送主题模式消息
     * @param target
     * @param message
     */
    public void sendTopicMessage(String target, Object message){
        Topic topic = new ActiveMQTopic(target);
        jmsMessagingTemplate.convertAndSend(target,message);
    }


}
