package ru.mg.esql.checkstyle.cli.commands

import org.apache.commons.cli.Options
import org.apache.commons.cli.HelpFormatter
import groovy.util.logging.Log4j
import ru.mg.esql.checkstyle.cli.options.OptionsUtils

/**
 * Make help
 */
@Log4j
class HelpCommand {

    private static final String SYNTAX = 'java -jar esqlcheck.jar -i <arg> -o <arg>'

    private Options options = OptionsUtils.options()

    void run() {
        ru.mg.esql.checkstyle.cli.commands.HelpCommand.log.info('Help command runned')
        def formatter = new HelpFormatter()

        ru.mg.esql.checkstyle.cli.commands.HelpCommand.log.debug('pring help for options $options')
        formatter.printHelp(SYNTAX, options)
    }

    String toString ( ) { 'Help command for options $options' }
}