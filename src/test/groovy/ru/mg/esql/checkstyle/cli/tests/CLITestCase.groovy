package ru.mg.esql.checkstyle.cli.tests

import groovy.util.logging.Log4j
import org.junit.Before
import org.junit.Test
import ru.mg.esql.checkstyle.cli.CLI
import static groovy.util.GroovyTestCase.assertEquals
import static junit.framework.Assert.assertNotNull
import static junit.framework.Assert.assertTrue
import org.apache.commons.cli.Options
import ru.mg.esql.checkstyle.cli.CLIOptions
import static junit.framework.Assert.assertEquals

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
        cli = new CLI()
    }

    @Test
    void testCLIConstruct() {
        assertNotNull('CLI construction is failed', cli)
    }

    @Test
    void testMakeEmptyOptions() {
        Options cliOpts = cli.makeOptions([])
        assertNotNull("CLI options is null", cliOpts)
        assertTrue("ru.mg.esql.checkstyle.cli.Options is not empty", cliOpts.options.isEmpty())
    }

    @Test
    void testMakeNullOptions() {
        Options cliOpts = cli.makeOptions(null)
        assertNotNull("CLI options is null", cliOpts)
        assertTrue("ru.mg.esql.checkstyle.cli.Options is not empty", cliOpts.options.isEmpty())
    }

    @Test
    void testMakeStandardOptions() {
        Options cliOpts = cli.makeOptions(new CLIOptions().run())
        assertEquals(cliOpts.options.size(), 3)
    }

    @Test
    void testToString() {
        assertEquals("CLI", cli.toString(),)
    }

}
