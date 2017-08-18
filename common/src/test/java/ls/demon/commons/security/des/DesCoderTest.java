/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security.des;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DesCoderTest.java, v 0.1 2017年8月18日 上午9:32:07 song.li@witontek.com Exp $
 */
public class DesCoderTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DesCoderTest.class);

    @Test
    public void test_001() {
        String src = "abcedft";
        String keyStr = "12345678";
        String et = DesCoder.encryptGBK(keyStr, src);
        logger.info("{}", et);
        logger.info("{}", DesCoder.decryptGBK(keyStr, et));
    }
}
