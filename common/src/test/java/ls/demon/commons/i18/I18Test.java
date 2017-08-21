/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.i18;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Test;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: I18Test.java, v 0.1 2017年8月21日 下午4:18:11 song.li@witontek.com Exp $
 */
public class I18Test {

    @Test
    public void test_001() {
        // http://www.cnblogs.com/jingmoxukong/p/5146027.html
        String pattern1 = "{0}，你好！你于  {1} 消费  {2} 元。";
        String pattern2 = "At {1,time,short} On {1,date,long}，{0} paid {2,number, currency}.";

        Object[] params = { "Jack", new GregorianCalendar().getTime(), 8888 };

        String msg1 = MessageFormat.format(pattern1, params);
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);

        System.out.println(msg1);
        System.out.println(msg2);
    }

    @Test
    public void test_002() {
        Locale[] localeList = Locale.getAvailableLocales();
        for (Locale l : localeList) {
            String s = String.format("%2$s=%1$s \t %4$s=%3$s", l.getDisplayCountry(),
                l.getCountry(), l.getDisplayLanguage(), l.getLanguage());
            System.out.println(s);
        }
    }
}
