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
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman is all";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String ,Object> womanMap = new HashMap<>();
        womanMap.put("messageId",messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange","topic.woman",womanMap);
    }

    /*
    消息推送到server，但是在server里找不到交换机
    这种情况触发的是 ConfirmCallback 回调函数。
     */
    @Test
    public void test3(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: non-existent-exchange test message";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String ,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("non-existent-exchange","TestDirectRouting",map);
    }

    /*
    消息推送到server，找到交换机了，但是没找到队列
    ②这种情况触发的是 ConfirmCallback和RetrunCallback两个回调函数。
     */
    @Test
    public void test4(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: lonelyDirectExchange test message";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String ,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
//        rabbitTemplate.convertAndSend("lonelyDirectExchange","TestDirectRouting",map);
        rabbitTemplate.convertAndSend("topicExchange","topic.msg4",map.toString());
    }

}
