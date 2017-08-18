package ls.demon.commons.security.des;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesCoder {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DesCoder.class);

    public static String encryptGBK(String keyStr, String src) {
        try {
            byte[] wrapKey = StringUtils.substring(keyStr, 0, 8).getBytes("ISO-8859-1");
            SecretKeySpec key = new SecretKeySpec(wrapKey, "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] bs = cipher.doFinal(src.getBytes("gbk"));

            return Base64.encodeBase64String(bs);
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    public static String decryptGBK(String keyStr, String secStr) {
        try {
            byte[] wrapKey = StringUtils.substring(keyStr, 0, 8).getBytes("ISO-8859-1");
            SecretKeySpec key = new SecretKeySpec(wrapKey, "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] bs = cipher.doFinal(Base64.decodeBase64(secStr));

            return new String(bs, "gbk");
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

}
