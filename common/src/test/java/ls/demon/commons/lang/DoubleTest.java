/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.lang;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DoubleTest.java, v 0.1 2017年8月22日 下午3:49:06 song.li@witontek.com Exp $
 */
public class DoubleTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DoubleTest.class);

    @Test
    public void test_001() {

        logger.info("{}", Double.toHexString(Double.NaN));
        logger.info("{}", Double.toHexString(Double.POSITIVE_INFINITY));
        logger.info("{}", Double.toHexString(Double.NEGATIVE_INFINITY));
        logger.info("{}", Double.toHexString(0.0));
        logger.info("{}", Double.toHexString(1.0));
        logger.info("{}", Double.toHexString(2.0));
        logger.info("{}", Double.toHexString(3.0));
        logger.info("{}", Double.toHexString(4.0));
        logger.info("{}", Double.toHexString(5.0));

        logger.info("====================");

        logger.info("{}", Long.toHexString(Double.doubleToRawLongBits(Double.NaN)));
        logger.info("{}", Long.toHexString(Double.doubleToRawLongBits(Double.POSITIVE_INFINITY)));
        logger.info("{}", Long.toHexString(Double.doubleToRawLongBits(Double.NEGATIVE_INFINITY)));
        logger.info("{}", Long.toHexString(Double.doubleToRawLongBits(Double.MIN_NORMAL)));
        logger.info("{}", Long.toHexString(Double.doubleToRawLongBits(0.0)));
        logger.info("{}", Long.toHexString(Double.doubleToRawLongBits(1.0)));
        logger.info("{}", Long.toHexString(Double.doubleToRawLongBits(2.0)));
        logger.info("{}", Long.toHexString(Double.doubleToRawLongBits(Double.MAX_VALUE)));

        logger.info("====================");
        logger.info("{}", Hex.encodeHexString(ByteUtils.toByte(0)));
        logger.info("{}", Hex.encodeHexString("a".getBytes()));
    }
}
