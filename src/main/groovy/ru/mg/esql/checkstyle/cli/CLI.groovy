package ru.mg.esql.checkstyle.cli

import groovy.util.logging.Log4j
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.GnuParser
import org.apache.commons.cli.Options
import org.apache.commons.cli.MissingArgumentException

/**
 * Command line parser.
 *
 * Define command line options and parse input.
 * @author : Michael Golovanov mike.golovanov@gmail.com
 */
@Log4j
class CLI {

    private def parser = new GnuParser()

    /**
     * Convert supported command line options to apache commons cli ru.mg.esql.checkstyle.cli.Options
     * @return apache commons cli ru.mg.esql.checkstyle.cli.Options
     */
    def makeOptions(def options) {
        log.debug("Make cli command line options $options")

        def cliOptions = new Options();
        // Make options
        options?.each { String o, params ->
            log.debug("Making option for $o with hasArgs = $params?.hasArgs and descr = params?.descr")
            cliOptions.addOption(o, params?.hasArgs as boolean, params?.descr as String)
        }

        log.debug('Make cli command line options done')
        return cliOptions
    }

    /**
     * Parse command line args aginst options
     * @param args - command line agrs
     * @return
     */
    def parseArgs(def args, def options = makeOptions(new CLIOptions().run())) {
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
    private def canRun(CommandLine cmdLine) {
        log.debug('Validate command line args')
        cmdLine.options.size() > 0 && cmdLine.hasOption('i') && cmdLine.hasOption('o') && !cmdLine.hasOption('h')
    }

    String toString() { "CLI" }
}
