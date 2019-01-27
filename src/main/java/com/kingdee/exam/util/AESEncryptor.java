package com.kingdee.exam.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;

// 128位长度的AES加密
public class AESEncryptor {
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final String ALGORITHM = "AES";

    private String aesKey="MndTEGr6Q87RK8I8";

    public AESEncryptor() {
    }

    /**
     * 加密
     */
    public String encrypt(String data) {
        byte[] ciperData = encrypt(data.getBytes(CHARSET));
        return Base64.encodeBase64String(ciperData);
    }

    /**
     * 加密
     */
    private byte[] encrypt(byte[] data) {
        Key k = new SecretKeySpec(aesKey.getBytes(CHARSET), ALGORITHM);
        byte[] raw = k.getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     */
    public String decrypt(String data) {
        byte[] plainData = decrypt(Base64.decodeBase64(data));
        return new String(plainData, CHARSET);
    }

    /**
     * 解密
     */
    private byte[] decrypt(byte[] data) {
        Key k = new SecretKeySpec(aesKey.getBytes(CHARSET), ALGORITHM);
        byte[] raw = k.getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
