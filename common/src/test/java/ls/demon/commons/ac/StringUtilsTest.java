/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: StringUtilsTest.java, v 0.1 2017年8月23日 上午9:22:16 song.li@witontek.com Exp $
 */
public class StringUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(StringUtilsTest.class);

    @Test
    public void test_001() {
        String test = "This is a test of the abbreviation.";
        String test2 = "Test";

        logger.info("{}", StringUtils.abbreviate(test, 10));
        logger.info("{}", StringUtils.abbreviate(test2, 10));

        logger.info("{}", StringUtils.abbreviateMiddle(test, "***", 11));
    }

    @Test
    public void test_002() {
        String input = "Frantically oblong";
        String input2 = "Pharmacy, basketball,funky";

        String[] array1 = StringUtils.split(input, " ,", 2);
        String[] array2 = StringUtils.split(input2, " ,", 2);

        System.out.println(ArrayUtils.toString(array1));
        System.out.println(ArrayUtils.toString(array2));

        logger.info("{}", StringUtils.repeat("*", 20));
        logger.info("{}", StringUtils.center("cc", 20, '*'));
        logger.info("{}", StringUtils.repeat("*", 20));

        logger.info("{}", StringUtils.reverse("I am Susan"));
        logger.info("{}", StringUtils.reverseDelimited("I am Susan", ' '));
    }

    @Test
    public void test_substr_between() {
        String input2 = "Pharmacy, basketball,funky";
        logger.info("{}", StringUtils.substringBetween(input2, ","));

    }
}
