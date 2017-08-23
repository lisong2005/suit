/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DateUtilsTest.java, v 0.1 2017年8月22日 下午5:11:32 song.li@witontek.com Exp $
 */
public class DateUtilsTest {

    @Test
    public void test_001() {
        Calendar cal = Calendar.getInstance();
        cal.set(2004, Calendar.MARCH, 5, 10, 2, 2);
        System.out.println(DateUtils.round(cal.getTime(), DateUtils.SEMI_MONTH));

        Calendar c2 = Calendar.getInstance();
        c2.set(2004, Calendar.MARCH, 10, 10, 2, 2);
        System.out.println(DateUtils.round(c2.getTime(), DateUtils.SEMI_MONTH));

        Calendar c3 = Calendar.getInstance();
        c3.set(2004, Calendar.MARCH, 27, 10, 2, 2);
        System.out.println(DateUtils.round(c3.getTime(), DateUtils.SEMI_MONTH));
    }
}
