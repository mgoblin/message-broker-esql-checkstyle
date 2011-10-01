@Typed package ru.mg.esql.checkstyle.cli.commands

interface Command<T> {
    T run(String... optionalArgs)
}
