package com.cat.amq.Consumer.impl;

/**
 * Created by 周杰伦 on 2018/2/14.
 */
import com.cat.amq.Consumer.ConsumerService;
import com.cat.message.TestMessage;
import org.springframework.stereotype.Component;

@Component("consumerService")
public class ConsumerServiceImpl implements ConsumerService {


    public void receiveMessage(String message) {
        System.out.println("消费方接收消息1:"+message);
    }
    public void receiveMessage2(String message) {
        System.out.println("消费方接收消息2:"+message);
    }

    public void receiveObject(TestMessage testMessage) {
        System.out.println("消费方接收对象："+ testMessage);
    }


    public void receiveTopicMessage(String message) {
        System.out.println("topic消费方接收消息1:"+message);
    }
    public void receiveTopicMessage2(String message) {
        System.out.println("topic消费方接收消息2:"+message);

    }

}
