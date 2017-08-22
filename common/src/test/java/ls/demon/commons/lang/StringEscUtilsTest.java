/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.lang;

import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: StringEscUtilsTest.java, v 0.1 2017年8月17日 下午2:22:46 song.li@witontek.com Exp $
 */
public class StringEscUtilsTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(StringEscUtilsTest.class);

    @Test
    public void test_001() {

        String input = "%u5C0F%u98DE%u4FA0"; //小飞侠
        try {
            logger.info("{}", StringEscapeUtils.escapeJava("äöü"));
            logger.info("{}", StringEscapeUtils.escapeJava("𐐀"));
            logger.info("{}", StringEscapeUtils.escapeJava("小飞侠"));
            logger.info("{}", StringEscapeUtils.escapeJava(input));
            logger.info("{}", StringEscapeUtils.unescapeJava(input));

            logger.info("-------------------");

            //            logger.info("{}", URLDecoder.decode(input, cs));
            logger.info("{}", URLEncoder.encode("小飞侠", "GBK"));
            logger.info("{}", URLEncoder.encode("小飞侠", "utf-8"));
            logger.info("{}", URLEncoder.encode("小飞侠", "utf-16"));
            logger.info("{}", URLEncoder.encode("小飞侠", "utf-16be")); // xxx
            logger.info("{}", URLEncoder.encode("小飞侠", "utf-16le"));
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_002() {
        try {
            logger.info("{}", ArrayUtils.toString("abc".toCharArray()));
            logger.info("{}", ArrayUtils.toString("中文".toCharArray()));
            logger.info("{}", ArrayUtils.toString("äöü".toCharArray()));
            logger.info("{}", ArrayUtils.toString("𐐀".toCharArray()));
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_003() {
        try {
            logger.info("{}", Charset.defaultCharset());
            logger.info("{}", ArrayUtils.toString("abc".getBytes()));
            logger.info("{}", ArrayUtils.toString("中文".getBytes()));
            logger.info("{}", ArrayUtils.toString("äöü".getBytes()));
            logger.info("{}", ArrayUtils.toString("𐐀".getBytes()));
            logger.info("=====================================");

            String utf8 = "utf-8";
            logger.info("{}", utf8);
            logger.info("{}", ArrayUtils.toString("abc".getBytes(utf8)));
            logger.info("{}", ArrayUtils.toString("中文".getBytes(utf8)));
            logger.info("{}", ArrayUtils.toString("äöü".getBytes(utf8)));
            logger.info("{}", ArrayUtils.toString("𐐀".getBytes(utf8)));
            logger.info("=====================================");

            String gbk = "gbk";
            logger.info("{}", gbk);
            logger.info("{}", ArrayUtils.toString("abc".getBytes(gbk)));
            logger.info("{}", ArrayUtils.toString("中文".getBytes(gbk)));
            logger.info("{}", ArrayUtils.toString("äöü".getBytes(gbk)));
            logger.info("{}", ArrayUtils.toString("𐐀".getBytes(gbk)));
            logger.info("=====================================");
        } catch (Exception e) {
            logger.error("", e);
        }

    }
}
