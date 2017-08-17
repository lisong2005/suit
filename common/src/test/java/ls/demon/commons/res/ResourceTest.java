/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.res;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import ls.demon.commons.lang.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ResourceTest.java, v 0.1 2017年8月17日 下午5:30:03 song.li@witontek.com Exp $
 */
public class ResourceTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ResourceTest.class);

    @Test
    public void test_mbg_create() {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

            logger.info("{}", BaseModel.class.getClassLoader());
            logger.info("{}", BaseModel.class.getClassLoader().getParent());
            logger.info("{}", BaseModel.class.getClassLoader().getParent().getParent());
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("{}", contextClassLoader);
            logger.info("{}", Thread.currentThread().getClass().getClassLoader());
            logger.info("{}", Thread.class.getClassLoader());
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            logger.info("{}", ResourceTest.class.getClassLoader());
            logger.info("{}", new BaseModel().getClass().getClassLoader());

            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            //            logger.info("{}", new BaseModel().getClass().getClassLoader().getResource("/").getPath());

            logger.info("{}", Thread.class.getResource("/").getPath());
            logger.info("{}", BaseModel.class.getResource("/").getPath());
            logger.info("{}", new BaseModel().getClass().getResource("/").getPath());
            logger.info("{}", new BaseModel().getClass().getResource("").getPath());

            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            logger.info("{}", contextClassLoader.getResource("logback.xml"));
            logger.info("{}", contextClassLoader.getResource("app.properties"));
            logger.info("{}", contextClassLoader.getResource("logback-test.xml"));
            logger.info("{}", contextClassLoader.getResource("app-test.properties"));

            logger.info("{}", BaseModel.class.getResource("app.properties"));
            logger.info("{}", BaseModel.class.getResource("/app.properties"));
            logger.info("{}", BaseModel.class.getResource("/app-test.properties"));

            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            ClassPathResource r = new ClassPathResource("/app.properties");
            logger.info("{}", r);
            logger.info("{}", r.getURL().getPath());

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test2() {
        try {
            ClassLoader classLoader = BaseModel.class.getClassLoader();
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            logger.info("{}", contextClassLoader.getResource("app.properties"));
            logger.info("{}", classLoader.getResource("app.properties"));

            logger.info("{}", classLoader
                .getResource("org/springframework/web/servlet/config/spring-mvc-3.0.xsd"));
            logger.info("{}", classLoader.getResource("org/springframework/util/Assert.class"));

            ClassPathResource r = new ClassPathResource("/app.properties");
            logger.info("{}", r);
            logger.info("{}", r.getURL().getPath());
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
