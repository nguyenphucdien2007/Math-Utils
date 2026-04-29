package com.example;

import java.io.File;

/** MATHUTILS. */
public class MathUtils {

  /** tim so lon hon. */
  public static int max(int a, int b) {
    if (a >= b) {
      return a;
    }
    return b;
  }

  /** Chia 2 so nguyen. */
  public static int divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("Divider must not be zero");
    }
    return a / b;
  }

  /** Tạo đường dẫn lưu file log (Cố tình gây lỗi đa nền tảng). */
  public static String createLogPath(String folder, String fileName) {
    return folder + File.separator + fileName;
  }
}
