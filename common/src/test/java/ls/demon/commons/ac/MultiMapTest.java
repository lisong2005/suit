/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Test;

import ls.demon.commons.lang.BaseTest;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: MultiMapTest.java, v 0.1 2017年8月25日 上午9:22:20 song.li@witontek.com Exp $
 */
public class MultiMapTest extends BaseTest {

    @Test
    public void test_001() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("one", "one");
        map.put("one", "1");
        map.put("one", "一");
        logger.info("{}", map);
        logger.info("{}", map.get("one"));
    }
}
