package ru.mg.esql.checkstyle.cli.tests

import groovy.util.logging.Log4j
import org.apache.commons.cli.Options
import org.junit.Before
import org.junit.Test
import ru.mg.esql.checkstyle.cli.CLI

import ru.mg.esql.checkstyle.cli.commands.HelpCommand
import static junit.framework.Assert.*
import ru.mg.esql.checkstyle.cli.commands.ParseESQLCommand
import ru.mg.esql.checkstyle.cli.options.OptionsUtils

/**
 * User: Michael Golovanov mike.golovanov@gmail.com
 * Date: 25.06.11
 * Time: 12:01
 */
@Log4j
class CLITestCase {

    def cli

    @Before
    void before() {
        log.debug('Run CLITestCase')
        cli = new CLI()
    }

    @Test
    void testCLIConstruct() {
        assertNotNull('CLI construction is failed', cli)
    }


    @Test
    void testMakeStandardOptions() {
        Options cliOpts = OptionsUtils.options()
        assertEquals('Bad options size', cliOpts.options.size(), 3)
    }

    @Test
    void testToString() {
        assertEquals("CLI", cli.toString(),)
    }

    @Test
    void testParseEmptyArgs() {
        assertEquals(cli.parseArgs([]).class, HelpCommand)
    }

    @Test
    void testParseArgs() {
        def args = ['-h']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-h', 'some']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-i']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-o']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-i', '/tmp.esql', '-o', '/tmp.ast', '-h']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-i', '/tmp.esql']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-o', '/tmp.ast']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-i', '/tmp.esql', '-h']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-o', '/tmp.ast', '-h']
        assertEquals(cli.parseArgs(args).class, HelpCommand)

        args = ['-i', '/tmp.esql', '-o', '/tmp.ast']
        assertEquals(cli.parseArgs(args).class, ParseESQLCommand)
    }

}
