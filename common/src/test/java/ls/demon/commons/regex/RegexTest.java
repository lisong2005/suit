/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.regex;

import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lisong
 * @version $Id: RegexTest.java, v 0.1 2017年8月18日 下午10:56:46 lisong Exp $
 */
public class RegexTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(RegexTest.class);

    @Test
    public void test_001() {
        logger.info("");
        Pattern p = Pattern.compile("^((2[5-9])|30)\\d{2,4}$");
        logger.info("{}", p.matcher("291").matches());
        logger.info("{}", p.matcher("2912").matches());
        logger.info("{}", p.matcher("29123").matches());
        logger.info("{}", p.matcher("291234").matches());
        logger.info("{}", p.matcher("2912345").matches());

        logger.info("{}", p.matcher("3012345").matches());
        logger.info("{}", p.matcher("311234").matches());
        logger.info("{}", p.matcher("301234").matches());
        logger.info("{}", p.matcher("3012").matches());
        logger.info("{}", p.matcher("301").matches());
    }

}
