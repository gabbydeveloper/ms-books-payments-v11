package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.utils;

import java.security.SecureRandom;

public class PasswordGenerator {

  private static final String CHARS =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";
  private static final int LENGTH = 12;

  public static String generateRandomPassword() {
    SecureRandom random = new SecureRandom();
    StringBuilder password = new StringBuilder(LENGTH);

    for (int i = 0; i < LENGTH; i++) {
      password.append(CHARS.charAt(random.nextInt(CHARS.length())));
    }
    return password.toString();
  }

}
