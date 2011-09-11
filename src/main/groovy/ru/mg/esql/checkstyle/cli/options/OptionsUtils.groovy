@Typed package ru.mg.esql.checkstyle.cli.options

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
        log.debug("Make cli command line options $options")

        Options cliOptions = new Options();
        // Make options
        options.each { Map.Entry o ->
            log.debug("Making option for ${o.key}")
            Map params = o.value
            cliOptions.addOption(o.key as String, params?.hasArgs as boolean, params?.descr as String)
        }

        log.debug('Make cli command line options done')
        return cliOptions
    }

}
