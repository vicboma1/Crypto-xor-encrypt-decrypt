package es.vicboma.crypto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CryptoTest {

  private Crypto crypto;

  @Before
  public void setUp() throws Exception {
    crypto = new Crypto();
  }

  @After
  public void tearDown() throws Exception {
    crypto = null;
  }

  @Test
  public void xorEncrypt() {
    final String encryptExpected = "Jyk8VjsKRxQ=";
    final String expected = "vicboma1";
    final String encryt = crypto.XorEncrypt(expected);
    assertEquals(encryptExpected,encryt);
  }

  @Test
  public void xorEncryptKey() {
    final String key = "@#~€¬";
    final String encryptExpected = "NkodXVAtQk8=";
    final String expected = "vicboma1";
    final String encryt = crypto.XorEncrypt(expected,key);
    assertEquals(encryptExpected,encryt);
  }

  @Test
  public void xorDecrypt() {
    final String encryptExpected = "Jyk8VjsKRxQ=";
    final String expected = "vicboma1";
    final String encryt = crypto.XorEncrypt(expected);
    assertEquals(encryptExpected,encryt);
    final String result = crypto.XorDecrypt(encryt);
    assertEquals(expected,result);
  }

  @Test
  public void xorDecryptKey() {
    final String key = "1452LmKi:";
    final String encryptExpected = "R11WUCMAKlg=";
    final String expected = "vicboma1";
    final String encryt = crypto.XorEncrypt(expected,key);
    assertEquals(encryptExpected,encryt);
    final String result = crypto.XorDecrypt(encryt,key);
    assertEquals(expected,result);
  }
}
