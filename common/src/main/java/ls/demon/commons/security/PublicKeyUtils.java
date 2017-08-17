/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PubKeyUtils.java, v 0.1 2017年8月17日 下午5:06:57 song.li@witontek.com Exp $
 */
public class PublicKeyUtils {

    public static PublicKey getPublicKeyFromX509(String base64PublicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] encodedKey = base64PublicKey.getBytes();
        return keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(encodedKey)));
    }
}
