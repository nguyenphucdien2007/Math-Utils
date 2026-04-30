package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Chạy mathUtil . */
public class Main {
  private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

  /**
   * Khởi chạy các method của MathUtils.
   *
   * @param args list chứa các chuỗi.
   */
  public static void main(String[] args) {
    logger.info("Max(8,9)=" + MathUtils.max(8, 9));
    logger.info("8:9=" + MathUtils.divide(8, 9));
  }
}
