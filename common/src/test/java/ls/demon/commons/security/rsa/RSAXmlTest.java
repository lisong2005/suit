/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security.rsa;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://stackoverflow.com/questions/12512455/rsa-key-xml-format-compatible-for-net
 * 
 * @author lisong
 * @version $Id: RSAXmlTest.java, v 0.1 2017年9月10日 下午8:23:42 lisong Exp $
 */
public class RSAXmlTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(RSAXmlTest.class);

    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.genKeyPair();
        RSAPrivateCrtKey privKey = (RSAPrivateCrtKey) keyPair.getPrivate();

        BigInteger n = privKey.getModulus();
        BigInteger e = privKey.getPublicExponent();
        BigInteger d = privKey.getPrivateExponent();
        BigInteger p = privKey.getPrimeP();
        BigInteger q = privKey.getPrimeQ();
        BigInteger dp = privKey.getPrimeExponentP();
        BigInteger dq = privKey.getPrimeExponentQ();
        BigInteger inverseQ = privKey.getCrtCoefficient();

        logger.info("{}", encode(n));
        logger.info("{}", encode2(n));

        StringBuilder builder = new StringBuilder();
        builder.append("<RSAKeyValue>\n");
        write(builder, "Modulus", n);
        write(builder, "Exponent", e);
        write(builder, "P", p);
        write(builder, "Q", q);
        write(builder, "DP", dp);
        write(builder, "DQ", dq);
        write(builder, "InverseQ", inverseQ);
        write(builder, "D", d);
        builder.append("</RSAKeyValue>");

        System.out.println(builder.toString());
    }

    private static void write(StringBuilder builder, String tag, BigInteger bigInt) {
        builder.append("\t<");
        builder.append(tag);
        builder.append(">");
        builder.append(encode2(bigInt));
        builder.append("</");
        builder.append(tag);
        builder.append(">\n");
    }

    private static String encode(BigInteger bigInt) {
        return Base64.encodeBase64String(bigInt.toByteArray());
        //        return new String(Base64.encodeInteger(bigInt), "ASCII");
    }

    private static String encode2(BigInteger bigInt) {
        return new String(Base64.encodeInteger(bigInt));
    }
}
