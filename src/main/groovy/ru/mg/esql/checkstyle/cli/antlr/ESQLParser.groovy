@Typed package ru.mg.esql.checkstyle.cli.antlr

import org.antlr.runtime.ANTLRInputStream
import ru.mg.esql.antlr.EsqlLexer

class ESQLParser {

    public parse(String esqlFileName) {
        def file = esqlFileName as File
        file.withInputStream { stream ->
            def input = new ANTLRInputStream(stream)
            new EsqlLexer(input)
        }
    }
}
