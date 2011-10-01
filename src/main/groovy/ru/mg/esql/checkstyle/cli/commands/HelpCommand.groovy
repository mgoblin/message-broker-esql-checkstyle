@Typed package ru.mg.esql.checkstyle.cli.commands

import org.apache.commons.cli.Options
import org.apache.commons.cli.HelpFormatter
import groovy.util.logging.Log4j
import ru.mg.esql.checkstyle.cli.options.OptionsUtils

/**
 * Make help
 */
@Log4j
class HelpCommand implements Command<String> {

    private static final String SYNTAX = 'java -jar esqlcheck.jar -i <esql_file> -o <ast_tree_file>'

    private Options options = OptionsUtils.options()

    private String withWriter(Function1<PrintWriter, ?> c) {
        def stringWriter = new StringWriter()
        try {
            c.call(new PrintWriter(stringWriter))
            return stringWriter.toString()
        } finally {
            stringWriter?.close()
        }
    }

    @Override
    String run(String... optionalArgs) {
        log.info('Help command runned')
        def formatter = new HelpFormatter()

        log.debug("pring help for options $options")
        withWriter {PrintWriter writer ->
            formatter.printHelp(
                    writer,
                    80,
                    SYNTAX,
                    'Available params',
                    options,
                    0,
                    10,
                    '')
        }
    }

    @Override
    String toString() { "Help command for options $options" }

}