package com.oopPlayground.solidPrinciple.FileReaderWriter.Readers;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;

public class TextFileBufferedReader extends TextFileReader {

    public List<String> read(Reader reader) {
        if (reader instanceof BufferedReader) {
            return read((BufferedReader) reader);
        } else {
            return super.read(reader);
        }
    }

    public List<String> read(BufferedReader reader) {
        return null;
    }
}
