
package ls.demon.commons.xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlSaxParseUtil {

    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(XmlSaxParseUtil.class);

    /**
     * 
     * @param xml
     * @return
     */
    public static Map<String, String> parse(String xml) {
        Map<String, String> params = new HashMap<String, String>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            WxSAXParserHandler handler = new WxSAXParserHandler();

            InputStream is = new ByteArrayInputStream(
                org.apache.commons.codec.binary.StringUtils.getBytesUtf8(xml));

            parser.parse(is, handler);
            params = handler.getValues();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return params;
    }

    static class WxSAXParserHandler extends DefaultHandler {

        /**  */
        private String              key    = null;

        /**  */
        private Map<String, String> values = new LinkedHashMap<String, String>();

        /**
         * Getter method for property <tt>values</tt>.
         * 
         * @return property value of values
         */
        public Map<String, String> getValues() {
            return values;
        }

        /** 
         * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
         */
        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            logger.debug("[startElement] qName={},attributes={}", qName, attributes);
            key = qName;
        }

        /** 
         * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
         */
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            logger.debug("[endElement] qName={}", qName);
            key = null;
        }

        /** 
         * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(content)) {
                values.put(key, content);
            }
            logger.debug("[characters] key={},content={}", key, content);
        }

    }
}
