package ru.mg.esql.checkstyle.cli

/**
 * User: Michael Golovanov mike.golovanov@gmail.com
 * Date: 25.06.11
 * Time: 12:01
 */
class CLITestCase extends GroovyTestCase {
    void testCLIConstruct() {
        def cli = new CLI()
        assertNotNull('CLI construction is failed', cli)
    }
}