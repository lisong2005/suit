/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Test;

import ls.demon.commons.lang.BaseTest;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BidiMapTest.java, v 0.1 2017年8月25日 上午9:29:03 song.li@witontek.com Exp $
 */
public class BidiMapTest extends BaseTest {

    @Test
    public void test_001() {
        BidiMap<String, String> map = new DualHashBidiMap<String, String>();
        map.put("one", "1");
        map.put("two", "2");
        logger.info("{}", map);
        logger.info("{}", map.get("one"));
        logger.info("{}", map.getKey("1"));
    }

}
