package ru.mg.esql.checkstyle.cli.options

import org.apache.commons.cli.Options
import groovy.util.logging.Log4j

/**
 * Options converter
 */
@Log4j
class OptionsUtils {
    /**
     * Convert supported command line options map to apache commons cli ru.mg.esql.checkstyle.cli.Options
     * @param options map
     * @return apache commons cli ru.mg.esql.checkstyle.cli.Options
     */
    public static Options options() {
        def options = new CLIOptions().run();
        ru.mg.esql.checkstyle.cli.options.OptionsUtils.log.debug("Make cli command line options $options")

        def cliOptions = new Options();
        // Make options
        options.each { o, params ->
            ru.mg.esql.checkstyle.cli.options.OptionsUtils.log.debug("Making option for $o with hasArgs = $params?.hasArgs and descr = params?.descr")
            cliOptions.addOption(o, params?.hasArgs, params?.descr)
        }

        ru.mg.esql.checkstyle.cli.options.OptionsUtils.log.debug('Make cli command line options done')
        return cliOptions
    }

}
