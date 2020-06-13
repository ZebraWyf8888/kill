package com.debug.kill.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class RabbitSenderService {
    public static final Logger log = LoggerFactory.getLogger(RabbitSenderService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    public void sendKillSuccessEmailMsg(String orderNo){
        log.info("秒杀成功，准备发送消息:{}",orderNo);
        try {
            //rabbitmq发送消息的逻辑
            //1.设置消息的格式
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            //2.设置routing key 和交换机
            rabbitTemplate.setExchange(env.getProperty("mq.kill.item.success.email.exchange"));
            rabbitTemplate.setRoutingKey(env.getProperty("mq.kill.item.success.email.routing.key"));
            //发送
            Message message = MessageBuilder.withBody(orderNo.getBytes("UTF-8")).build();
            rabbitTemplate.convertAndSend(message);
        } catch (Exception e) {
            log.error("秒杀异常消息通知:{}",e.fillInStackTrace());
            e.printStackTrace();
        }
        log.info("秒杀成功，发送消息:{}",orderNo);

    }
}
