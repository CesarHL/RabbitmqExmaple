package com.nearsoft.listener;

/**
 *
 */
public interface MqListener {

  /**
   * @param message
   */
  void onMessage(String message);

}
