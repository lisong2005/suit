/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DurationFormatUtilsTest.java, v 0.1 2017年8月23日 上午8:51:13 song.li@witontek.com Exp $
 */
public class DurationFormatUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DurationFormatUtilsTest.class);

    @Test
    public void test_001() {
        logger.info("{}", DurationFormatUtils.formatDurationHMS(1001));
        logger.info("{}", DurationFormatUtils.formatDurationHMS(1000001));
        logger.info("{}", DurationFormatUtils.formatDurationISO(System.currentTimeMillis()));
        logger.info("{}", DurationFormatUtils.formatDurationISO(System.currentTimeMillis() / 2));
        logger.info("{}", DurationFormatUtils.formatDurationISO(DateUtils.MILLIS_PER_DAY * 400));
        logger.info("{}", DurationFormatUtils.formatPeriodISO(0, System.currentTimeMillis()));
    }
}
