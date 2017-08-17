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

}
