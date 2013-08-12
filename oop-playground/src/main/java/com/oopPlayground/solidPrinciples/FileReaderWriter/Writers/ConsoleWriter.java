package com.oopPlayground.solidPrinciples.FileReaderWriter.Writers;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class ConsoleWriter implements IWriter, IConsoleWriter {

    public void write(Writer writer, List<String> contents) {
        if (writer instanceof PrintWriter) {
            write((PrintWriter) writer, contents);
        } else {
            write(new PrintWriter(new PrintStream(System.out)), contents);
        }
    }

    public void write(PrintWriter writer, List<String> contents) {
        for (String line : contents) {
            writer.println(line);
        }
        writer.flush();
    }

    public void write(List<String> contents) {
        for (String line : contents) {
            System.out.println(line);
        }
    }
}

