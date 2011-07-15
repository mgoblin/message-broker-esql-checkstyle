package ru.mg.esql.checkstyle.cli

import groovy.util.logging.Log4j
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.GnuParser
import org.apache.commons.cli.Options
import org.apache.commons.cli.MissingArgumentException
import org.apache.commons.cli.Parser

/**
 * Command line parser.
 *
 * Define command line options and parse input.
 * @author : Michael Golovanov mike.golovanov@gmail.com
 */
@Log4j
class CLI {

    private Options opts = OptionsUtils.options()

    def Parser parser = new GnuParser()

    /**
     * Parse command line args aginst options
     * @param args - command line agrs
     * @options command line options
     * @return  command for ags
     */
    def parseArgs(def args, Options options = opts) {
        log.info('Starting command line args parsing')
        log.debug("Parse command line args $args with options $options")

        // Parse agrs
        try {
            def cmdLine = parser.parse(options, args as String[])
            log.debug('Command line object cteated')

            // Analyze user input
            if (canRun(cmdLine)) {
                log.debug('Parse ESQL command selected')
                return new ParseESQLCommand()
            } else {
                log.debug('Help command selected')
                return new HelpCommand()
            }
        } catch (MissingArgumentException e) {
            // Command line have errors - show help
            log.debug('Help command selected')
            return new HelpCommand()
        } finally {
            log.info('Command line args parsing finished')
        }
    }

    /**
     * Validate command line args
     * @param cmdLine command line object
     * @return true if args are valid, otherwise false
     */
    private boolean canRun(CommandLine cmdLine) {
        log.debug('Validate command line args')
        cmdLine.options.size() > 0 && cmdLine.hasOption('i') && cmdLine.hasOption('o') && !cmdLine.hasOption('h')
    }

    String toString() { "CLI" }
}
