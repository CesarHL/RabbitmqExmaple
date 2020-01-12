package com.nearsoft.listener;

import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MessageListener implements MqListener {

  /**
   *
   * @param message
   */
  @Override
  public void onMessage(String message) {
    try {
      Thread.sleep(3600);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.err.println("Message Received: " + message);
  }

}
