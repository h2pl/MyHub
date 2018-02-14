/**
 * Created by 周杰伦 on 2018/2/14.
 */
import javax.annotation.Resource;

import com.cat.amq.Producer.ProducerService;
import com.cat.message.TestMessage;
import org.junit.Test;


public class ActivemqTest extends SpringTestCase{

    @Resource(name = "producerService")
    private ProducerService producerService;

    @Test
    public void simpleSend(){
        producerService.sendMessage("study.queue.simple", "简单文本消息测试");
    }

    @Test
    public void ObjectSend(){
        TestMessage testMessage = new TestMessage();
        testMessage.setId(1);
        testMessage.setMsg("对象消息。。。");
        producerService.sendMessage("study.queue.object", testMessage);
    }

    @Test
    public void simpleTopicSend(){
        producerService.sendTopicMessage("study.topic.simple", "topic简单文本消息测试");
    }
}