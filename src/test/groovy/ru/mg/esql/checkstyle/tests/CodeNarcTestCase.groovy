package ru.mg.esql.checkstyle.tests

import groovy.util.logging.Log4j

/**
 * Run codenarc as junit test
 */
class CodeNarcTestCase extends GroovyTestCase {
    private static final GROOVY_FILES = '**/*.groovy'
    private static final RULESET_FILES = [
            'rulesets/basic.xml',
            'rulesets/imports.xml',
            'rulesets/exceptions.xml'].join(',')

    void testRunCodeNarc() {
        def ant = new AntBuilder()

        ant.taskdef(name:'codenarc', classname:'org.codenarc.ant.CodeNarcTask')
        ant.codenarc(ruleSetFiles:RULESET_FILES,
           maxPriority1Violations:0, maxPriority2Violations:0, maxPriority3Violations:0) {

           fileset(dir:'src/main/groovy') {
               include(name:GROOVY_FILES)
           }
           report(type:'html') {
               option(name:'outputFile', value:'src/codeNarcReport.html')
           }
        }
    }
}
