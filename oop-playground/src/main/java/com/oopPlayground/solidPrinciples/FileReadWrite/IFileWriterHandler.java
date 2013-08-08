package com.oopPlayground.solidPrinciples.FileReadWrite;

public interface IFileWriterHandler {
    public void writeAllLines(String contents);

    public void writeFirstLines(String contents, int lineCount);
}
