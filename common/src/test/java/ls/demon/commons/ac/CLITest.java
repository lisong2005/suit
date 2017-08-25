/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package ls.demon.commons.ac;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.junit.Test;

import ls.demon.commons.lang.BaseTest;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CLITest.java, v 0.1 2017年8月25日 下午4:02:52 song.li@witontek.com Exp $
 */
public class CLITest extends BaseTest {

    private static final String USAGE  = "[-h] [-v] [-f <file> | -m <email>]";

    private static final String HEADER = "SomeApp - A fancy and expensive program, Copyright 2010 Blah.";

    private static final String FOOTER = "For more instructions, see our website at: http://www.blah123.org";

    public void func(String[] args) throws Exception {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE information");

        OptionGroup optionGroup = new OptionGroup();
        Option mailArg = Option.builder("m").longOpt("email").hasArg().argName("email")
            .desc("mailAddress").build();
        Option fileArg = Option.builder("f").longOpt("file").hasArg().argName("file")
            .desc("filename").build();

        optionGroup.addOption(fileArg);
        optionGroup.addOption(mailArg);

        options.addOptionGroup(optionGroup);

        CommandLine commandLine = parser.parse(options, args);
        if (commandLine.hasOption('h')) {
            printUsage(options);
            // System.exit(0);
        }

    }

    private static void printUsage(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.setWidth(80);
        helpFormatter.printHelp(USAGE, HEADER, options, FOOTER);
    }

    @Test
    public void test_001() {
        try {
            new CLITest().func(new String[] { "-h" });
            logger.info("");
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_002() {
        try {
            new CLITest().func(new String[] { "--help" });
            logger.info("");
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_003() {
        try {
            Option opt = Option.builder("D").hasArgs().valueSeparator('=').build();
            Options options = new Options();
            options.addOption(opt);

            String[] args = { "-Dkey=value", "-Da=b" };
            CommandLineParser parser = new DefaultParser();
            CommandLine line = parser.parse(options, args);

            logger.info("{}", line.getOptionProperties("D"));
            logger.info("{}", line.getOptionProperties("D").get("key"));
            logger.info("{}", line.getOptionProperties("D").get("a"));

        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
