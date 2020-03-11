package com.lmf.esdemo.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TopicReceiver {

    @RabbitListener(queues = "topic.msg1")
    public void topicMsg1(String map){
        System.out.print("topic.msg1 ：");
        System.out.println(map);
    }
    @RabbitListener(queues = "topic.msg2")
    public void topicMsg2(String map){
        System.out.print("topic.msg2 ：");
        System.out.println(map);
    }
    @RabbitListener(queues = "topic.msg3")
    public void topicMsg3(String map){
        System.out.print("topic.msg3 ：");
        System.out.println(map);
    }
    @RabbitListener(queues = "topic.msg4")
    public void topicMsg4(String map){
        System.out.print("topic.msg4 ：");
        System.out.println(map);
    }
    @RabbitListener(queues = "topic.msg5")
    public void topicMsg5(String map){
        System.out.print("topic.msg5 ：");
        System.out.println(map);
    }

}
