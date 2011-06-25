package ru.mg.esql.checkstyle

import groovy.util.logging.Log4j
import org.antlr.runtime.ANTLRInputStream
import org.apache.commons.cli.Options
import org.apache.commons.cli.CommandLineParser
import org.apache.commons.cli.PosixParser
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.GnuParser
import ru.mg.esql.checkstyle.cli.CLI

/**
 * Main class. Tool entry point
 * @author Michael Golovanov (mike.golovanov@gmail.com)
 */

@Log4j
class Main {
    def static main(args) {
        log.debug('Run main')

        def cli = new CLI()
        println cli

        log.debug('Finish main')
    }
}
