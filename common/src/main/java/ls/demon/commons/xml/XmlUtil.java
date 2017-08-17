/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.commons.xml;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XmlUtil.java, v 0.1 2016年8月5日 上午9:15:01 song.li@witontek.com Exp $
 */
public class XmlUtil {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    public static <T> T convertToObj(Class<T> clazz, String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(new StringReader(xml)));
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    public static String convertToXml(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();

            StringWriter sw = new StringWriter();
            marshaller.marshal(obj, sw);
            return sw.toString();
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    public static String readXmlFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(filePath), "utf-8"))) {

            String firstLine = br.readLine();
            if (StringUtils.startsWith(firstLine, "<xml>")) {
                StringBuilder sb = new StringBuilder();
                sb.append(firstLine);
                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        return sb.toString();
                    }
                    sb.append(line);
                }
            }
            return null;
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }
}
