/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.integration;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SpringBootWebApplication.java, v 0.1 2017年9月1日 下午12:10:43 song.li@witontek.com Exp $
 */
@SpringBootApplication
public class SpringBootWebApplication {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(SpringBootWebApplication.class);

    public static void main(String[] args) throws Exception {
        logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        logger.info("{}", ArrayUtils.toString(args));
        logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
