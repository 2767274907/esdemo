package com.lmf.esdemo.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    /**
     *  创建三个队列 ：fanout.A   fanout.B  fanout.C
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */

    @Bean
    public Queue queue1(){
        return new Queue("que1");
    }
    @Bean
    public Queue queue2(){
        return new Queue("que2");
    }
    @Bean
    public Queue queue3(){
        return new Queue("que3");
    }
    @Bean
    public Queue queue4(){
        return new Queue("que4");
    }
    @Bean
    public Queue queue5(){
        return new Queue("que5");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchange1(){
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchange2(){
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchange3(){
        return BindingBuilder.bind(queue3()).to(fanoutExchange());
    }
    @Bean
    Binding bindingExchange4(){
        return BindingBuilder.bind(queue4()).to(fanoutExchange());
    }
    @Bean
    Binding bindingExchange5(){
        return BindingBuilder.bind(queue5()).to(fanoutExchange());
    }

}