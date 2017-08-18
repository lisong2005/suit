/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: RsaUtils.java, v 0.1 2017年8月18日 上午10:55:40 song.li@witontek.com Exp $
 */
public class RSAUtils {

    /**
     * 非对称加密密钥算法
     */
    public static final String KEY_ALGORITHM = "RSA";

    public static RSAKeyPair gen(int keySize) throws Exception {
        RSAKeyPair kp = new RSAKeyPair();
        // 实例化密钥对生成器
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        // 初始化密钥对生成器
        keyPairGen.initialize(keySize);
        // 生成密钥对
        KeyPair keyPair = keyPairGen.generateKeyPair();

        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        kp.publicKey = publicKey;
        kp.privateKey = privateKey;
        return kp;
    }

    // ====================================================
    // ====================================================

    // 私钥加密 
    public static byte[] encryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    // 公钥解密 
    public static byte[] decryptByPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    // ====================================================
    // ====================================================

    // 公钥加密
    public static byte[] encryptByPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    // 私钥解密
    public static byte[] decryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    // ====================================================
    // ====================================================

    public static class RSAKeyPair {
        RSAPublicKey  publicKey;
        RSAPrivateKey privateKey;

        public RSAPublicKey getPublicKey() {
            return publicKey;
        }

        public RSAPrivateKey getPrivateKey() {
            return privateKey;
        }

    }
}
