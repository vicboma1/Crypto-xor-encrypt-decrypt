package es.vicboma.crypto;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @Author: vicboma1
 */
public class Crypto {

  private static final String XOR_KEY = "Q@_4Tg&%K";
  private static final String REGEX = "\\s";
  private static final String REPLACEMENT = "";

  private BASE64Decoder decoder;
  private BASE64Encoder encoder;

  public Crypto() {
    decoder = new BASE64Decoder();
    encoder = new BASE64Encoder();
  }

  public String XorDecrypt(final String s) {
    return XorDecrypt(s ,XOR_KEY);
  }

  public String XorEncrypt(final String s) {
    return XorEncrypt(s, XOR_KEY);
  }

  public String XorEncrypt(final String s, final String key) {
    return base64Encode(xorWithKey(s.getBytes(), key.getBytes()));
  }

  public String XorDecrypt(final String s, final String key) {
    return new String(xorWithKey(base64Decode(s), key.getBytes()));
  }

  private byte[] xorWithKey(final byte[] a, final byte[] key) {
    final byte[] out = new byte[a.length];
    for (int i = 0; i < a.length; i++) {
      out[i] = (byte) (a[i] ^ key[i%key.length]);
    }
    return out;
  }

  private byte[] base64Decode(final String s) {
    try {
      return decoder.decodeBuffer(s);
    } catch (final Exception e) {
      throw new RuntimeException(e);}
  }

  private String base64Encode(final byte[] bytes) {
    return encoder.encode(bytes).replaceAll(REGEX, REPLACEMENT);
  }
}
