package com.lmf.esdemo.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FanoutReceiver {

    @RabbitListener(queues = "que1")
    public void que1(Map map){
        System.out.println("que1接受消息："+map.toString());
    }
    @RabbitListener(queues = "que2")
    public void que2(Map map){
        System.out.println("que2接受消息："+map.toString());
    }
    @RabbitListener(queues = "que3")
    public void que3(Map map){
        System.out.println("que3接受消息："+map.toString());
    }
    @RabbitListener(queues = "que4")
    public void que4(Map map){
        System.out.println("que4接受消息："+map.toString());
    }
    @RabbitListener(queues = "que5")
    public void que5(Map map){
        System.out.println("que5接受消息："+map.toString());
    }

}
