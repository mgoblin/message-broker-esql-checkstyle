package ru.mg.esql.checkstyle.cli.tests

import org.junit.Test
import static ru.mg.esql.checkstyle.cli.options.OptionsUtils.options
import static junit.framework.Assert.assertEquals
import org.apache.commons.cli.Options

class OptionUtilsTestCase {
    @Test
    void testOptions() {
        def opts = new Options()
        opts.addOption('h', false, 'print this message')
        opts.addOption('i', true, 'input ESQL file name')
        opts.addOption('o', true, 'output AST-tree file')

        assertEquals(opts.toString(), options().toString())
    }

    @Test
    void testDoubleCall() {
        def opts = new Options()
        opts.addOption('h', false, 'print this message')
        opts.addOption('i', true, 'input ESQL file name')
        opts.addOption('o', true, 'output AST-tree file')

        assertEquals(opts.toString(), options().toString())
        assertEquals(opts.toString(), options().toString())
    }
}
