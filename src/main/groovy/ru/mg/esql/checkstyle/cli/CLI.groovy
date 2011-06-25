package ru.mg.esql.checkstyle.cli

import groovy.util.logging.Log4j
import org.apache.commons.cli.Options
import org.codenarc.*

/**
 * User: Michael Golovanov mike.golovanov@gmail.com
 * Date: 25.06.11
 * Time: 11:21
 */

@Log4j
class CLI {
    def options

    CLI() {
        log.debug('Entering constructor')

        options = defineOptions()

        log.debug('Leaving constructor')
    }

    private def defineOptions() {
        log.debug('Define command line options')
        def opts = new Options();
        log.debug('Define command line options done')
        return opts
    }

    String toString() { "CLI { options = $options }" }
}
