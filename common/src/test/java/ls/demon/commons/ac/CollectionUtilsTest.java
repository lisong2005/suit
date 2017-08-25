/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import ls.demon.commons.lang.BaseTest;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CollectionUtilsTest.java, v 0.1 2017年8月25日 下午2:28:07 song.li@witontek.com Exp $
 */
public class CollectionUtilsTest extends BaseTest {

    @Test
    public void test_001() {
        String[] arrayA = new String[] { "1", "2", "3", "3", "4", "5" };
        String[] arrayB = new String[] { "3", "4", "4", "5", "6", "7" };

        List<String> a = Arrays.asList(arrayA);
        List<String> b = Arrays.asList(arrayB);

        Collection<String> union = CollectionUtils.union(a, b);
        Collection<String> intersection = CollectionUtils.intersection(a, b);
        Collection<String> disjunction = CollectionUtils.disjunction(a, b);
        Collection<String> subtract = CollectionUtils.subtract(a, b);

        System.out.println("A: " + ArrayUtils.toString(a.toArray()));
        System.out.println("B: " + ArrayUtils.toString(b.toArray()));
        System.out.println("Union: " + ArrayUtils.toString(union.toArray()));
        System.out.println("Intersection: " + ArrayUtils.toString(intersection.toArray()));
        System.out.println("Disjunction: " + ArrayUtils.toString(disjunction.toArray()));
        System.out.println("Subtract: " + ArrayUtils.toString(subtract.toArray()));
    }

}
