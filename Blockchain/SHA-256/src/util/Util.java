package util;

import java.security.MessageDigest;

public class Util {

  public static String getHash(String input) {

    StringBuffer result = new StringBuffer();

    try {

      MessageDigest md = MessageDigest.getInstance("SHA-256");
      //사용자로부터 받은 입력을 SHA-256 해시를 적용하여 그 값을 바이트 배열 형태로 반환한다.

      md.update(input.getBytes());

      byte bytes[] = md.digest();

      for(int i = 0; i < bytes.length; i++) {

        result.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));

      }

    } catch (Exception e) {

      e.printStackTrace();

    }

    return result.toString();

  }

}