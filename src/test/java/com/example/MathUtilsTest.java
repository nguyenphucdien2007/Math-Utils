package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** Test cho các hàm tiện ích toán học và hệ thống. */
public class MathUtilsTest {
  static MathUtils mathUtils;
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(MathUtilsTest.class);

  @BeforeAll
  public static void setUp() {
    mathUtils = new MathUtils();
    logger.info("=== Bắt đầu khởi chạy bộ test MathUtilsTest ===");
  }

  @Test
  public void testMax1() {
    logger.info("Test max() case 1: Hai số dương bình thường (5 và 3)");
    assertEquals(5, mathUtils.max(5, 3));
  }

  @Test
  public void testMax2() {
    logger.info("Test max() case 2: Hai số dương đảo ngược vị trí (10 và 20)");
    assertEquals(20, mathUtils.max(10, 20));
  }

  @Test
  public void testMax3() {
    logger.info("Test max() case 3: Cả hai số đều là 0");
    assertEquals(0, mathUtils.max(0, 0));
  }

  @Test
  public void testMax4() {
    logger.info("Test max() case 4: Biên giá trị cực đại và cực tiểu (MAX_VALUE và MIN_VALUE)");
    assertEquals(Integer.MAX_VALUE, mathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
  }

  @Test
  public void testMax5() {
    logger.info("Test max() case 5: Cả hai số đều là MIN_VALUE");
    assertEquals(Integer.MIN_VALUE, mathUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE));
  }

  @Test
  public void testMax6() {
    logger.info("Test max() case 6: Các giá trị tiệm cận MAX_VALUE");
    assertEquals(
        Integer.MAX_VALUE - 1, mathUtils.max(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2));
  }

  @Test
  public void divide1() {
    logger.info("Test divide() case 1: Phép chia hết cơ bản (10 / 5)");
    assertEquals(2, mathUtils.divide(10, 5));
  }

  @Test
  public void divide2() {
    logger.info("Test divide() case 2: Phép chia có số âm (9 / -3)");
    assertEquals(-3, mathUtils.divide(9, -3));
  }

  @Test
  public void divide3() {
    logger.info("Test divide() case 3: Tử số bằng 0 (0 / 5)");
    assertEquals(0, mathUtils.divide(0, 5));
  }

  @Test
  public void divide4() {
    logger.info("Test divide() case 4: Mẫu số bằng 0, kỳ vọng ném ra IllegalArgumentException");
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> mathUtils.divide(-5, 0));
    // Dùng log debug để in ra message của exception nhằm xác nhận chi tiết mà không làm rác log
    // info
    logger.debug("Bắt được Exception đúng kỳ vọng. Message: {}", exception.getMessage());
  }

  @Test
  public void testCreateLogPath() {
    logger.info("Test createLogPath(): Kiểm tra thuật toán nối đường dẫn đa nền tảng");
    String expectedPath = "logs" + File.separator + "app.log";
    String actualPath = MathUtils.createLogPath("logs", "app.log");

    logger.debug("Đường dẫn kỳ vọng: {} | Đường dẫn thực tế: {}", expectedPath, actualPath);
    assertEquals(expectedPath, actualPath, "Đường dẫn không khớp với chuẩn của hệ điều hành!");
  }

  @AfterAll
  public static void done() {
    logger.info("=== Kết thúc bộ test MathUtilsTest ===");
  }
}
