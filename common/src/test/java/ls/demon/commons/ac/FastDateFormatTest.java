/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: FastDateFormatTest.java, v 0.1 2017年8月22日 下午4:53:47 song.li@witontek.com Exp $
 */
public class FastDateFormatTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(FastDateFormatTest.class);

    @Test
    public void test_001() {
        FastDateFormat f1 = FastDateFormat.getDateInstance(FastDateFormat.FULL);
        FastDateFormat f2 = FastDateFormat.getDateInstance(FastDateFormat.LONG);
        FastDateFormat f3 = FastDateFormat.getDateInstance(FastDateFormat.MEDIUM);
        FastDateFormat f4 = FastDateFormat.getDateInstance(FastDateFormat.SHORT);

        Date date = new Date();
        logger.info("{}", f1.format(date));
        logger.info("{}", f2.format(date));
        logger.info("{}", f3.format(date));
        logger.info("{}", f4.format(date));
    }

    @Test
    public void test_002() {
        FastDateFormat f1 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        logger.info("{}", f1.format(date));
        logger.info("{}", DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(date));
    }
}
