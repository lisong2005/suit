/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WordUtilsTest.java, v 0.1 2017年8月23日 上午9:14:57 song.li@witontek.com Exp $
 */
public class WordUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(WordUtilsTest.class);

    @Test
    public void test_001() {
        logger.info("{}", WordUtils.capitalize("𐐀"));
    }
}
