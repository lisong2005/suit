/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.codec.language.Soundex;
import org.junit.Test;

import ls.demon.commons.lang.BaseTest;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SoundexTest.java, v 0.1 2017年8月23日 上午10:29:23 song.li@witontek.com Exp $
 */
public class SoundexTest extends BaseTest {

    @Test
    public void test_001() {
        Soundex soundex = new Soundex();
        logger.info("{}", soundex.soundex("a"));
        logger.info("{}", soundex.soundex("b"));
        logger.info("{}", soundex.soundex("c"));
        logger.info("{}", soundex.soundex("ab"));
        logger.info("{}", soundex.soundex("ac"));
        logger.info("{}", soundex.soundex("abc"));
        logger.info("{}", soundex.soundex("1"));
        logger.info("{}", soundex.soundex("2"));
        logger.info("{}", soundex.soundex("3"));
    }
}
