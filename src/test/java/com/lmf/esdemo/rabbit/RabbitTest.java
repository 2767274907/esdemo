package com.lmf.esdemo.rabbit;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
public class RabbitTest {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @Test
    public void test1(){
//        for (int i=1;i<=10;i++){
            String messageId = String.valueOf(UUID.randomUUID());
//            String messageData = "第次"+i+"发送";
            String messageData = "fanout : test";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String ,Object> map = new HashMap<>();
            map.put("messageId",messageId);
            map.put("messageData", messageData);
            map.put("createTime", createTime);
            rabbitTemplate.convertAndSend("fanoutExchange",null,map);
//        }
    }

    @Test
    public void test2(){
        rabbitTemplate.convertAndSend("topicExchange","topic.msg1","test topic222");
        rabbitTemplate.convertAndSend("topicExchange","topic.msg2","test topic3333");
        rabbitTemplate.convertAndSend("topicExchange","topic.msg3","test topic4444");
        rabbitTemplate.convertAndSend("topicExchange","topic.msg4","test topic55555");
        rabbitTemplate.convertAndSend("topicExchange","topic.msg5","test topic666666");
    }

}
