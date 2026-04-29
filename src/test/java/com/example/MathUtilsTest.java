package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** Test. */
public class MathUtilsTest {
  static MathUtils mathUtils;
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(MathUtilsTest.class);

  @BeforeAll
  public static void setUp() {
    mathUtils = new MathUtils();
     logger.info("=== Bắt đầu test ===");
  }

  @Test
  public void testMax1() {
    assertEquals(5, mathUtils.max(5, 3));
  }

  @Test
  public void testMax2() {
    assertEquals(20, mathUtils.max(10, 20));
  }

  @Test
  public void testMax3() {
    assertEquals(0, mathUtils.max(0, 0));
  }

  @Test
  public void testMax4() {
    assertEquals(Integer.MAX_VALUE, mathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
  }

  @Test
  public void testMax5() {
    assertEquals(Integer.MIN_VALUE, mathUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE));
  }

  @Test
  public void testMax6() {
    assertEquals(
        Integer.MAX_VALUE - 1, mathUtils.max(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2));
  }

  @Test
  public void divide1() {
    assertEquals(2, mathUtils.divide(10, 5));
  }

  @Test
  public void divide2() {
    assertEquals(-3, mathUtils.divide(9, -3));
  }

  @Test
  public void divide3() {
    assertEquals(0, mathUtils.divide(0, 5));
  }

  @Test
  public void divide4() {
    assertThrows(IllegalArgumentException.class, () -> mathUtils.divide(-5, 0));
  }

  @Test
  public void testCreateLogPath() {
    String expectedPath = "logs" + File.separator + "app.log";
    String actualPath = MathUtils.createLogPath("logs", "app.log");
    assertEquals(expectedPath, actualPath, "Đường dẫn không khớp với chuẩn của hệ điều hành!");
  }

  @AfterAll
  public static void done() {
    logger.info("=== Kết thúc test ===");
  }
}
