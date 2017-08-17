/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security;

import java.security.cert.X509Certificate;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: X509CertificateUtilsTest.java, v 0.1 2017年8月17日 下午3:40:50 song.li@witontek.com Exp $
 */
public class X509CertificateUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(X509CertificateUtilsTest.class);

    @Test
    public void test_001() {
        try {
            X509Certificate c = X509CertificateUtils.getCertFromFile("d:/certs/ls.txt");

            String encodeBase64String = Base64.encodeBase64String(c.getEncoded());
            String encodeHexString = Hex.encodeHexString(c.getEncoded());
            logger.info("{}", encodeBase64String);
            logger.info("{}", encodeHexString);

            X509CertificateUtils.getCertFromBase64Str(encodeBase64String);
            X509CertificateUtils.getCertFromHexStr(encodeHexString);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_002() {
        try {
            String encodeHexString = "30819c300d06092a864886f70d010101050003818a003081860281807d1e98e9c10625239ad9116488accf18a95125c83f5ac52f055be47614087b1bc55f1d475ddb0516b6339f7c2a8fd4def86519087cc6ecd8ea4657a5cef26d84890d00772d216e95d0aba1ea9fd39fb02202c82b71333b104e715da5de65be4cf5b83e3c0ba459777fe83a39485f145fccc94b471981348db5beab735c5889f1020111";
            logger.info("{}", encodeHexString);

            X509CertificateUtils.getCertFromHexStr(encodeHexString);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    // ========================================
    // ========================================
    // ========================================

}
