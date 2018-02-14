package com.cat.amq.Producer.impl;

/**
 * Created by 周杰伦 on 2018/2/14.
 */
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import com.cat.amq.Producer.ProducerService;
import com.cat.message.TestMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


@Component("producerService")
public class ProducerServiceImpl implements ProducerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;


    public void sendMessage(String destinationName,  final String message) {
        System.out.println("生产方发送字符串消息:"+message);
        jmsTemplate.send(destinationName, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });

    }

    public void sendMessage(String destinationName, final TestMessage testMessage) {
        System.out.println("生产方发送对象消息:"+testMessage);

        /*jmsTemplate.send(destinationName, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(testMessage);
            }
        });*/
        jmsTemplate.convertAndSend(destinationName, testMessage);
    }

    public void sendTopicMessage(String destinationName, String message){
        System.out.println("生产方发送文本消息:"+message);
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(destinationName, message);
    }

}