package com.oopPlayground.solidPrinciple.FileReaderWriter.Writers;

import java.io.BufferedWriter;
import java.io.Writer;
import java.util.List;

public class TextFileBufferedWriter extends TextFileWriter {

    public void write(Writer writer, List<String> contents) {
        if (writer instanceof BufferedWriter) {
            write((BufferedWriter) writer, contents);
        } else {
            super.write(writer, contents);
        }
    }

    public void write(BufferedWriter writer, List<String> contents) {

    }
}
