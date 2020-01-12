package com.nearsoft.config;

import com.nearsoft.listener.MqListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


  @Value("${spring.rabbitmq.routingKey}")
  private String routingKey;

  @Value("${spring.rabbitmq.exchange}")
  private String exchange;

  @Bean
  public Queue queue() {
    return new Queue(routingKey, true);
  }

  @Bean
  public TopicExchange exchange() {
    return new TopicExchange(exchange);
  }

  @Bean
  public Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(routingKey);
  }

  @Bean
  public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
      MessageListenerAdapter listenerAdapter) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(routingKey);
    container.setMessageListener(listenerAdapter);
    return container;
  }

  @Bean
  public MessageListenerAdapter myQueueListener(MqListener listener) {
    return new MessageListenerAdapter(listener, "onMessage");
  }

}
