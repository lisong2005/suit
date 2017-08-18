/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security.md5;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Md5Test.java, v 0.1 2017年8月18日 下午1:34:04 song.li@witontek.com Exp $
 */
public class Md5Test {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(Md5Test.class);

    @Test
    public void test_md5() {
        logger.info("{}", DigestUtils.md5Hex("abc"));
    }
}
