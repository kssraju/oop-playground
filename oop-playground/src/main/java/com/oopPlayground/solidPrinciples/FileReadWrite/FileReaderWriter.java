package com.oopPlayground.solidPrinciples.FileReadWrite;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReaderWriter {

    public void readFileAndWriteAllContentToConsole(String readFromFile) {
        FileOpenHandler openHandler = new FileOpenHandler();
        try {
            Reader reader = openHandler.openForRead(readFromFile);
            FileReadHandler readHandler = new FileReadHandler(reader);
            String fileContents = readHandler.readAllLines();
            IFileWriterHandler consoleWriter = new ConsoleWriterHandler();
            consoleWriter.writeAllLines(fileContents);
            openHandler.close(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileAndWriteFirstLinesToConsole(String readFromFile, int linesToWrite) {
        FileOpenHandler openHandler = new FileOpenHandler();
        try {
            Reader reader = openHandler.openForRead(readFromFile);
            FileReadHandler readHandler = new FileReadHandler(reader);
            String fileContents = readHandler.readAllLines();
            IFileWriterHandler consoleWriter = new ConsoleWriterHandler();
            consoleWriter.writeFirstLines(fileContents, linesToWrite);
            openHandler.close(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileAndWriteAllContentToFile(String readFromFile, String writeToFile) {
        FileOpenHandler openHandler = new FileOpenHandler();
        try {
            Reader reader = openHandler.openForRead(readFromFile);
            FileReadHandler readHandler = new FileReadHandler(reader);
            String fileContents = readHandler.readAllLines();
            Writer writer = openHandler.openForWrite(writeToFile);
            IFileWriterHandler fileWriter = new FileWriterHandler(writer);
            fileWriter.writeAllLines(fileContents);
            openHandler.close(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileAndWriteFirstLinesToFile(String readFromFile, String writeToFile, int linesToWrite) {
        FileOpenHandler openHandler = new FileOpenHandler();
        try {
            Reader reader = openHandler.openForRead(readFromFile);
            FileReadHandler readHandler = new FileReadHandler(reader);
            String fileContents = readHandler.readAllLines();
            Writer writer = openHandler.openForWrite(writeToFile);
            IFileWriterHandler fileWriter = new FileWriterHandler(writer);
            fileWriter.writeFirstLines(fileContents, linesToWrite);
            openHandler.close(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
