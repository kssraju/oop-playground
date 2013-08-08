package com.oopPlayground.solidPrinciples.FileReadWrite;

import org.junit.BeforeClass;
import org.junit.Test;

public class FileReadWriteTests {

    private static TestHelper testHelper;
    private static String readFromFilePath;
    private static String writeToFilePath;

    @BeforeClass
    public static void initialize() {
        readFromFilePath = "/home/abhimanyu/Learning/OOP/SOLID/Read_FileReaderWriteTestFile.txt";
        testHelper = new TestHelper();
        testHelper.createTestFile(readFromFilePath, "Hello World!\nThis is a new line in the file");
    }

    @Test
    public void shouldReadFromFileAndWriteAllContentsToConsole() {
        FileReaderWriter readerWriter = new FileReaderWriter();

        readerWriter.readFileAndWriteAllContentToConsole(readFromFilePath);
    }

    @Test
    public void shouldReadFileAndWriteFirstLinesToConsole() {
        int linesToWrite = 1;
        FileReaderWriter readerWriter = new FileReaderWriter();

        readerWriter.readFileAndWriteFirstLinesToConsole(readFromFilePath, linesToWrite);
    }

    @Test
    public void shouldReadFileAndWriteAllContentToFile() {
        FileReaderWriter readerWriter = new FileReaderWriter();
        writeToFilePath = "/home/abhimanyu/Learning/OOP/SOLID/WriteAll_FileReaderWriteTestFile.txt";

        readerWriter.readFileAndWriteAllContentToFile(readFromFilePath, writeToFilePath);
    }

    @Test
    public void shouldReadFileAndWriteFirstLinesToFile() {
        int linesToWrite = 1;
        FileReaderWriter readerWriter = new FileReaderWriter();
        writeToFilePath = "/home/abhimanyu/Learning/OOP/SOLID/WriteFirstLine_FileReaderWriteTestFile.txt";

        readerWriter.readFileAndWriteFirstLinesToFile(readFromFilePath, writeToFilePath, linesToWrite);
    }
}
