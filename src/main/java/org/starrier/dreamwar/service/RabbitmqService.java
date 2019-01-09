package org.starrier.dreamwar.service;

import org.springframework.amqp.rabbit.support.CorrelationData;
import org.starrier.dreamwar.entity.UserDto;
import org.starrier.dreamwar.enums.ExchangeEnum;

/**
 * @Author Starrier
 * @Time 2018/11/11.
 */
public interface RabbitmqService {

    /**
     * 发送消息到rabbitmq消息队列
     * @param message 消息内容
     * @param exchangeEnum 交换配置枚举
     * @param routingKey 路由key
     * @throws Exception
     */
    void send(ExchangeEnum exchangeEnum, String routingKey, Object message) throws Exception;

    /**
     * 发送消息到 rabbitmq 消息队列，发送 ack.
     *
     * @param exchangeEnum {@link ExchangeEnum}
     * @param routingKey {@link ExchangeEnum}
     * @param user  {@link UserDto}
     * @param correlationData {@link CorrelationData}
     * */
    void userRegisterSendAndAck(ExchangeEnum exchangeEnum, String routingKey, UserDto user, CorrelationData correlationData);
}
