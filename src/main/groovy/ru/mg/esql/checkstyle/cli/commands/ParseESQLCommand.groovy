@Typed package ru.mg.esql.checkstyle.cli.commands

/**
 * Parse ESQL file
 */
class ParseESQLCommand implements Command {

    String esqlFileName

    String astFileName

    void run(String... optionalArgs) { 'Not implemented yet.' }

    String toString() { "Parse ESQL command: esql file: $esqlFileName, ast file: $astFileName" }
}
