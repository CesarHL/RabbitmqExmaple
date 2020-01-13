package com.nearsoft.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MqMessageListener implements MessageListener {

  /**
   *
   * @param message
   */
  @Override
  public void onMessage(Message message) {
    System.err.println("Message Received: " + new String(message.getBody()));
  }

}
