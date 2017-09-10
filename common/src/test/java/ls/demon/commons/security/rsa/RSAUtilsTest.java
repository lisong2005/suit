/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security.rsa;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ls.demon.commons.security.PrivateKeyUtils;
import ls.demon.commons.security.rsa.RSAUtils.RSAKeyPair;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: RSAUtilsTest.java, v 0.1 2017年8月18日 上午11:07:50 song.li@witontek.com Exp $
 */
public class RSAUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(RSAUtilsTest.class);

    private RSAKeyPair          keys   = null;

    @Before
    public void setup() {
        try {
            keys = RSAUtils.gen(2048);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_001() {
        logger.info("私钥\n{}", Base64.encodeBase64String(keys.getPrivateKey().getEncoded()));
        logger.info("公钥\n{}", Base64.encodeBase64String(keys.getPublicKey().getEncoded()));

        try {
            String txt = "hello";
            byte[] data = txt.getBytes();
            byte[] encryptData = RSAUtils.encryptByPrivateKey(data, keys.getPrivateKey());
            byte[] decryptData = RSAUtils.decryptByPublicKey(encryptData, keys.getPublicKey());
            logger.info("原始明文\n{}", txt);
            logger.info("密文\n{}", Base64.encodeBase64String(encryptData));
            logger.info("解密明文\n{}", new String(decryptData));
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_002() {
        logger.info("私钥\n{}", Base64.encodeBase64String(keys.getPrivateKey().getEncoded()));
        logger.info("公钥\n{}", Base64.encodeBase64String(keys.getPublicKey().getEncoded()));

        try {
            String txt = "hello";
            byte[] data = txt.getBytes();
            byte[] encryptData = RSAUtils.encryptByPublicKey(data, keys.getPublicKey());
            byte[] decryptData = RSAUtils.decryptByPrivateKey(encryptData, keys.getPrivateKey());
            logger.info("原始明文\n{}", txt);
            logger.info("密文\n{}", Base64.encodeBase64String(encryptData));
            logger.info("解密明文\n{}", new String(decryptData));
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_003() {
        RSAPrivateKey priKey = keys.getPrivateKey();
        RSAPublicKey pubKey = keys.getPublicKey();

        logger.info("{} {}", priKey.getAlgorithm(), priKey.getFormat());
        logger.info("{} {}", pubKey.getAlgorithm(), pubKey.getFormat());
        logger.info("私钥\n{}", priKey);
        logger.info("公钥\n{}", pubKey);
        logger.info("公钥\n{}", Hex.encodeHexString(pubKey.getEncoded()));

    }

    @Test
    public void test_004() {
        try {
            RSAPrivateKey priKey = keys.getPrivateKey();
            RSAPublicKey pubKey = keys.getPublicKey();

            PublicKey pubKey2 = PrivateKeyUtils.getPublicKeyFromPrivateKey(priKey);
            logger.info("{}", Base64.encodeBase64String(pubKey.getEncoded()));
            logger.info("{}", Base64.encodeBase64String(pubKey2.getEncoded()));
            logger.info("xxxxxxxxxxxxxxxxxx");

            RSAPrivateCrtKey privKey = (RSAPrivateCrtKey) priKey;
            logger.info("{}", Base64.encodeBase64String(priKey.getEncoded()));
            logger.info("{}", Base64.encodeBase64String(privKey.getEncoded()));
            logger.info("xxxxxxxxxxxxxxxxxx");

            RSAPrivateCrtKeySpec pks = new RSAPrivateCrtKeySpec(privKey.getModulus(),
                privKey.getPublicExponent(), privKey.getPrivateExponent(), privKey.getPrimeP(),
                privKey.getPrimeQ(), privKey.getPrimeExponentP(), privKey.getPrimeExponentQ(),
                privKey.getCrtCoefficient());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey2 = keyFactory.generatePrivate(pks);

            logger.info("{}", Base64.encodeBase64String(priKey.getEncoded()));
            logger.info("{}", Base64.encodeBase64String(priKey2.getEncoded()));
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
