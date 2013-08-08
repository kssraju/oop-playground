package com.oopPlayground.solidPrinciples.FileReadWrite;

import java.io.*;

public class FileOpenHandler {
    public Reader openForRead(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        return new BufferedReader(reader);
    }

    public Writer openForWrite(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        return new BufferedWriter(writer);
    }

    public void close(Reader reader) throws IOException {
        reader.close();
    }
}

