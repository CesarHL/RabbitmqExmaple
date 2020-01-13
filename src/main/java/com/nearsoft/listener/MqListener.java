package com.nearsoft.listener;

import org.springframework.amqp.core.Message;

/**
 *
 */
public interface MqListener {

  /**
   * @param message
   */
  void onMessage(Message message);

}
