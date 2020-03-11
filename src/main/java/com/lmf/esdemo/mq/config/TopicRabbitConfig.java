package com.lmf.esdemo.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/

@Configuration
public class TopicRabbitConfig {
    //绑定键
    public final static String man = "topic.man";
    public final static String woman = "topic.woman";

    @Bean
    public Queue firstQueue() {
        return new Queue(TopicRabbitConfig.man);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(TopicRabbitConfig.woman);
    }

    @Bean
    public Queue msg1Queue() {
        return new Queue("topic.msg1");
    }
    @Bean
    public Queue msg2Queue() {
        return new Queue("topic.msg2");
    }
    @Bean
    public Queue msg3Queue() {
        return new Queue("topic.msg3");
    }
    @Bean
    public Queue msg4Queue() {
        return new Queue("topic.msg4");
    }
    @Bean
    public Queue msg5Queue() {
        return new Queue("topic.msg5");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }

    //将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }

    @Bean
    Binding bindingMsg1(){
        return BindingBuilder.bind(msg1Queue()).to(exchange()).with("topic.msg1");
    }
    @Bean
    Binding bindingMsg2(){
        return BindingBuilder.bind(msg2Queue()).to(exchange()).with("topic.msg2");
    }
    @Bean
    Binding bindingMsg3(){
        return BindingBuilder.bind(msg3Queue()).to(exchange()).with("topic.msg3");
    }
    @Bean
    Binding bindingMsg4(){
        return BindingBuilder.bind(msg4Queue()).to(exchange()).with("topic.msg4");
    }
    @Bean
    Binding bindingMsg5(){
        return BindingBuilder.bind(msg5Queue()).to(exchange()).with("topic.#");
    }



}