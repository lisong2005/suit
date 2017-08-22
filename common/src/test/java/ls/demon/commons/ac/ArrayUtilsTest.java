/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ArrayUtilsTest.java, v 0.1 2017年8月22日 下午1:39:33 song.li@witontek.com Exp $
 */
public class ArrayUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ArrayUtilsTest.class);

    @Test
    public void test_001() {
        String[] strings = new String[] { "Blue", "Green", null, "Yellow" };
        logger.info("{}", ArrayUtils.toString(strings));
        logger.info("{}", Arrays.toString(strings));

        int[] intArray = new int[] { 2, 3, 4, 5, 6 };
        logger.info("{}", ArrayUtils.toString(intArray));
        logger.info("{}", Arrays.toString(intArray));

        int[][] multiDimension = new int[][] { { 1, 2, 3 }, { 2, 3 }, { 5, 6, 7 } };
        logger.info("{}", ArrayUtils.toString(multiDimension));
        logger.info("{}", Arrays.toString(multiDimension));
        logger.info("{}", Arrays.deepToString(multiDimension));

    }

    @Test
    public void test_002() {
        long[] array = { 1, 3, 2, 3, 5, 6 };
        long[] reversed = ArrayUtils.clone(array);
        ArrayUtils.reverse(reversed);

        System.out.println("Original: " + ArrayUtils.toString(array));
        System.out.println("Reversed: " + ArrayUtils.toString(reversed));
    }

    @Test
    public void test_003() {
        Long[] array = new Long[] { new Long(3), new Long(56), new Long(233) };
        Long[] reversed = ArrayUtils.clone(array);
        ArrayUtils.reverse(reversed);

        System.out.println("Original: " + ArrayUtils.toString(array));
        System.out.println("Reversed: " + ArrayUtils.toString(reversed));
    }
}
