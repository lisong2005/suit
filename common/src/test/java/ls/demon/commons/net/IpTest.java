/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.net;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: IpTest.java, v 0.1 2017年8月21日 上午11:00:16 song.li@witontek.com Exp $
 */
public class IpTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(IpTest.class);

    @Test
    public void test_0001() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface
                .getNetworkInterfaces();

            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                logger.info("{}", netInterface.getName());
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();

                    if (ip.isSiteLocalAddress()) {
                        logger.info("== isSite");
                    }

                    if (ip != null && ip instanceof Inet4Address) {
                        logger.info("本机的IP = " + ip.getHostAddress());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    @Test
    public void test_001() {
        try {
            System.out.println(Inet4Address.getLocalHost().getHostAddress());
            System.out.println(InetAddress.getLocalHost().getHostAddress());

            InetAddress IP = InetAddress.getLocalHost();
            System.out.println("IP of my system is := " + IP.getHostAddress());
            System.out.println(IP.toString());
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_002() {
        try {
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_003() {
        try {
            try (final DatagramSocket socket = new DatagramSocket()) {
                socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
                String ip = socket.getLocalAddress().getHostAddress();
                logger.info("{}", ip);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_004() {
        try {
            InetAddress[] allByName = InetAddress.getAllByName("wpay.witontek.com");
            for (InetAddress i : allByName) {
                logger.info("{}", i.getHostAddress());
            }
            InetAddress[] all2 = InetAddress.getAllByName("rbtest.witontek.com");
            for (InetAddress i : all2) {
                logger.info("{}", i.getHostAddress());
            }
            InetAddress[] all3 = InetAddress.getAllByName("www.alipay.com");
            for (InetAddress i : all3) {
                logger.info("{}", i.getHostAddress());
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
