/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: X509CertificateUtils.java, v 0.1 2017年8月17日 下午3:39:29 song.li@witontek.com Exp $
 */
public class X509CertificateUtils {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(X509CertificateUtils.class);

    public static X509Certificate getCertFromFile(String path) {
        try (FileInputStream in = new FileInputStream(path);) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate encryptCertTemp = (X509Certificate) cf.generateCertificate(in);
            logger.info("[{}][CertId={}]", path, encryptCertTemp.getSerialNumber());
            return encryptCertTemp;
        } catch (Exception e) {
            logger.error("InitCert Error", e);
        }
        return null;
    }

    public static X509Certificate getCertFromStr(String certStr) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(certStr.getBytes("ISO-8859-1"));) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate encryptCertTemp = (X509Certificate) cf.generateCertificate(in);
            logger.info("[CertId={}]", encryptCertTemp.getSerialNumber());
            return encryptCertTemp;
        } catch (Exception e) {
            logger.error("InitCert Error", e);
        }
        return null;
    }

    private static String newCert(String encodeBase64String) {
        return "-----BEGIN CERTIFICATE-----\n" + encodeBase64String + "\n-----END CERTIFICATE-----";
    }

    public static X509Certificate getCertFromBase64Str(String base64Str) {
        return getCertFromStr(newCert(base64Str));
    }

    public static X509Certificate getCertFromHexStr(String hexStr) {
        try {
            return getCertFromBase64Str(
                Base64.encodeBase64String(Hex.decodeHex(hexStr.toCharArray())));
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }
}
