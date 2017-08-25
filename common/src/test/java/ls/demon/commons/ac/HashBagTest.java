/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;

import ls.demon.commons.lang.BaseTest;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: HashBagTest.java, v 0.1 2017年8月25日 上午9:03:31 song.li@witontek.com Exp $
 */
public class HashBagTest extends BaseTest {

    @Test
    public void test_001() {
        Bag<String> bag = new HashBag<>();

        bag.add("a", 100);
        bag.add("b", 10);

        logger.info("{}", bag);

        bag.remove("a", 20);
        bag.remove("b", 1);

        logger.info("{}", bag);
    }

}
