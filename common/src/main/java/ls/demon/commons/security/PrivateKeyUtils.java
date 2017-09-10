/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PrivateKeyUtils.java, v 0.1 2017年8月17日 下午5:09:37 song.li@witontek.com Exp $
 */
public class PrivateKeyUtils {

    public static PrivateKey getPrivateKeyFromPKCS8(String base64PrivateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] encodedKey = base64PrivateKey.getBytes();
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64(encodedKey)));
    }

    public static PublicKey getPublicKeyFromPrivateKey(PrivateKey myPrivateKey) throws Exception {
        RSAPrivateCrtKey privk = (RSAPrivateCrtKey) myPrivateKey;

        RSAPublicKeySpec publicKeySpec = new java.security.spec.RSAPublicKeySpec(privk.getModulus(),
            privk.getPublicExponent());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey myPublicKey = keyFactory.generatePublic(publicKeySpec);
        return myPublicKey;
    }
}
