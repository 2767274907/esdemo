package com.lmf.esdemo.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    //队列 起名TestDirectQueue
    @Bean
    public Queue TestDirectQueue(){
     return new Queue("TestDirectQueue",true);  //true为是否持久
    }

    //DirectExchange交换机 起名TestDirectExchange（直连型交互机）
    @Bean
    DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange");
    }

    //绑定 将队列和交互机绑定，并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }


}
