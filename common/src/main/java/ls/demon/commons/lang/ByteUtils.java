/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.lang;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ByteUtils.java, v 0.1 2017年8月22日 下午4:27:31 song.li@witontek.com Exp $
 */
public class ByteUtils {

    public static byte[] toByte(long longValue) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);) {
            dos.writeLong(longValue);
            return bos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }
}
