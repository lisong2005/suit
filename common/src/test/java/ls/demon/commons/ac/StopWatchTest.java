/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: StopWatchTest.java, v 0.1 2017年8月23日 上午8:38:01 song.li@witontek.com Exp $
 */
public class StopWatchTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(StopWatchTest.class);

    @Test
    public void test_001() {
        try {
            StopWatch sw = StopWatch.createStarted();
            Thread.sleep(500);
            sw.split();
            Thread.sleep(500);

            logger.info("{} {}", sw.toSplitString(), sw.getSplitTime());

            sw.unsplit();
            sw.stop();
            logger.info("{} {}", sw.toString(), sw.getTime());
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
