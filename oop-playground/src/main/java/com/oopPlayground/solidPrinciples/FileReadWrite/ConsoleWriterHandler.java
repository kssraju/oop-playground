package com.oopPlayground.solidPrinciples.FileReadWrite;

public class ConsoleWriterHandler implements IFileWriterHandler{
    public void writeAllLines(String contents) {
        System.out.println(contents);
    }

    public void writeFirstLines(String contents, int lineCount) {
        String[] lines = contents.split("\n");
        for (int i = 0; i < lineCount && i < lines.length; i++) {
            System.out.println(lines[i]);
        }
    }
}

