package com.oopPlayground.solidPrinciple.FileReaderWriter;

import com.oopPlayground.solidPrinciple.FileReaderWriter.Readers.IReader;
import com.oopPlayground.solidPrinciple.FileReaderWriter.Writers.IWriter;

import java.util.List;

public class FileReaderWriter {

    private IWriter writer;
    private IReader reader;

    List<String> contents;

    public FileReaderWriter(IWriter writer, IReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public List<String> readAllLines(String... files) {
        return null;
    }

    public List<String> readLines(String file, int offset, int lineCount) {
        return null;
    }

    public void writeAllLines(String file) {

    }

    public void writeAllLines() {

    }

    public void writeLines(int offset, int lineCount) {

    }

    public void writeLines(String file, int offset, int lineCount) {

    }
}
