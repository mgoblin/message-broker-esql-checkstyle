@Typed package ru.mg.esql.checkstyle.cli

import groovy.util.logging.Log4j
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.GnuParser
import org.apache.commons.cli.Options
import org.apache.commons.cli.MissingArgumentException
import org.apache.commons.cli.Parser
import ru.mg.esql.checkstyle.cli.options.OptionsUtils
import ru.mg.esql.checkstyle.cli.commands.ParseESQLCommand
import ru.mg.esql.checkstyle.cli.commands.HelpCommand
import ru.mg.esql.checkstyle.cli.commands.Command

/**
 * Command line parser.
 *
 * Define command line options and parse input.
 * @author : Michael Golovanov mike.golovanov@gmail.com
 */
@Log4j
class CLI {

    private Options opts = OptionsUtils.options()

    Parser parser = new GnuParser()

    /**
     * Parse command line args aginst options
     * @param args - command line agrs
     * @options command line options
     * @return command for ags
     */
    Command parseArgs(def args, Options options = opts) {
        log.info('Starting command line args parsing')
        log.debug("Parse command line args $args with options $options")

        Command selectedCommand = new HelpCommand()

        // Parse agrs
        try {
            def cmdLine = parser.parse(options, args as String[])
            log.debug('Command line object cteated')

            // Analyze user input
            if (canRun(cmdLine)) {
                log.debug('Parse ESQL command selected')
                selectedCommand = new ParseESQLCommand(
                        esqlFileName: cmdLine.getOptionValue('i'),
                        astFileName: cmdLine.getOptionValue('o')
                )
            }

        } catch (MissingArgumentException e) {
            // Command line have errors - show help
            log.debug('Help command selected')
        } finally {
            log.info('Command line args parsing finished')
        }

        log.debug("Finally selected $selectedCommand" )
        return selectedCommand
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
