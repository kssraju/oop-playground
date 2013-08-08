package com.oopPlayground.solidPrinciples.FileReadWrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class FileReadHandler {

    Reader reader;

    public FileReadHandler(Reader reader) {
        this.reader = reader;
    }

    public String readAllLines() {
        return read().toString();
    }

//    public List<String> readFirstLines(String filePath, int lineCount) {
//        String[] lines = read(filePath).toString().split("\n");
//        String[] linesToRead = new String[lineCount];
//        for (int i = 0; i < lineCount && i < lines.length; i++) {
//            linesToRead[i] = lines[i];
//        }
//        return Arrays.asList(linesToRead);
    //}

    private StringBuilder read() {
        StringBuilder content = new StringBuilder();
        try {

            int count = 0;
            while ((count = reader.read()) != -1) {
                content.append((char) count);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return content;
        }
    }
}

