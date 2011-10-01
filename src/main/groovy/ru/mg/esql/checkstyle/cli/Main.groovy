@Typed package ru.mg.esql.checkstyle.cli

import groovy.util.logging.Log4j

@Log4j
class Main {
    public static void main(String[] args) {
        log.info('ESQL Checkstyle running')
        log.debug(args)
        def cli = new CLI()
        log.debug("CLI created")
        def command = cli.parseArgs(args)
        log.info("Run  " + command)
        command.run()
        log.info("Completed")
    }
}
