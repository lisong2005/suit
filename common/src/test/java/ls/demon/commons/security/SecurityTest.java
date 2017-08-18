/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.security;

import java.security.Provider;
import java.security.Security;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SecurityTest.java, v 0.1 2017年8月18日 下午12:01:39 song.li@witontek.com Exp $
 */
public class SecurityTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(SecurityTest.class);

    @Test
    public void test_show() {
        Provider[] ps = Security.getProviders();
        for (Provider p : ps) {
            logger.info("{}:{} - {}", p.getName(), p.getVersion(), p.getInfo());
        }
    }
}
