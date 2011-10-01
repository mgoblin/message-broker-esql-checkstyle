@Typed package ru.mg.esql.checkstyle.cli.commands

import groovy.util.logging.Log4j

/**
 * Parse ESQL file
 */
@Log4j
class ParseESQLCommand implements Command {

    String esqlFileName

    String astFileName

    @Override
    Object run(String... optionalArgs) {
        log.debug('ParseESQLCommand running')
        switch (optionalArgs.length) {
            case 0:
                log.debug('0')
                return runCommand()
            case 1:
                log.debug('1')
                return runCommand(optionalArgs[0])
            case 2:
                log.debug('2')
                return runCommand(optionalArgs[0], optionalArgs[1])
            default: throw new IllegalArgumentException("Only two params supported. The first esql file name and the second ast file name")
        }
    }

    private Object runCommand(String esqlFileName, String astFileName) {
        // Place code here
        return null
    }

    private Object runCommand(String esql) {
        runCommand(esql, astFileName)
    }

    private Object runCommand() {
        runCommand(esqlFileName, astFileName)
    }

    @Override
    String toString() { "Parse ESQL command: esql file: $esqlFileName, ast file: $astFileName" }
}
