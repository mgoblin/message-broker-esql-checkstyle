package ru.mg.esql.checkstyle.cli

import groovy.util.logging.Log4j
import org.apache.commons.cli.Options

/**
 * Command line parser.
 *
 * Define command line options and parse input.
 * @author : Michael Golovanov mike.golovanov@gmail.com
 */
@Log4j
class CLI {

    /**
     * Convert supported command line options to apache commons cli ru.mg.esql.checkstyle.cli.Options
     * @return apache commons cli ru.mg.esql.checkstyle.cli.Options
     */
    def makeOptions(def options) {
        log.debug('Make cli command line options')

        def cliOptions = new Options();
        // Make options
        options?.each { String o, params -> cliOptions.addOption(o, params.hasArgs, params.descr)}

        log.debug('Make cli command line options done')
        return cliOptions
    }

    String toString() { "CLI" }
}
