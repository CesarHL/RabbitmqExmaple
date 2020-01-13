package com.nearsoft.config;

import com.nearsoft.listener.MqListener;
import com.nearsoft.listener.MqMessageListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


  @Value("${spring.rabbitmq.routingKey}")
  private String queueName;

  @Value("${spring.rabbitmq.exchange}")
  private String exchange;

  @Bean
  public Queue queue() {
    return new Queue(queueName, Boolean.FALSE);
  }

  @Bean
  public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory ) {
    SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
    simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
    simpleMessageListenerContainer.setQueues(queue());
    simpleMessageListenerContainer.setMessageListener(new MqMessageListener());
    return simpleMessageListenerContainer;
  }

}
