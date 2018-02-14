package com.cat.amq.Consumer;

import com.cat.message.TestMessage;

/**
 * Created by 周杰伦 on 2018/2/14.
 */

public interface ConsumerService {
    /**
     * 消费方 接受字符串
     * @param message
     */
    public void receiveMessage(String message);
    /**
     * 消费方 接受对象
     * @param message
     */
    public void receiveObject(TestMessage testMessage);

    /**
     * 消费方 topic 接受字符串
     * @param message
     */
    public void receiveTopicMessage(String message);

    /**
     * 消费方 topic 接受字符串
     * @param message
     */
    public void receiveTopicMessage2(String message);

}