package com.oopPlayground.solidPrinciples.FileReadWrite;

import java.io.IOException;
import java.io.Writer;

public class FileWriterHandler implements IFileWriterHandler {

    Writer writer;

    public FileWriterHandler(Writer writer) {
        this.writer = writer;
    }

    public void writeAllLines(String contents) {
        write(contents);
    }


    public void writeFirstLines(String contents, int linesToWrite) {
        String[] lines = contents.split("\n");
        StringBuilder contentBuilder = new StringBuilder();
        for (int i = 0; i < linesToWrite && i < lines.length; i++) {
            contentBuilder.append(lines[i]);
        }
        write(contentBuilder.toString());
    }

    private void write(String contents) {
        try {

            writer.write(contents);

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
