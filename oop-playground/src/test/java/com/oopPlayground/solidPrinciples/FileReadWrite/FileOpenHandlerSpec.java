package com.oopPlayground.solidPrinciples.FileReadWrite;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class FileOpenHandlerSpec {

    private static TestHelper testHelper;
    private static String filePath;

    @BeforeClass
    public static void initialize() {
        filePath = "/home/abhimanyu/Learning/OOP/SOLID/FileOpenHandlerSpecFile.txt";
        testHelper = new TestHelper();
        testHelper.createTestFile(filePath, "Hello World!\nThis is a new line in the file");
    }

    @Test
    public void shouldOpenFileForRead() {
        FileOpenHandler openHandler = new FileOpenHandler();
        try {
            openHandler.openForRead(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException in opening the file");
        }
    }

    @Test
    public void shouldOpenFileForWrite() {
        FileOpenHandler openHandler = new FileOpenHandler();
        try {
            openHandler.openForWrite(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException in opening the file");
        }
    }

    @Test
    public void shouldThrowIOExceptionForNoFileToRead() {
        FileOpenHandler openHandler = new FileOpenHandler();
        try {
            openHandler.openForRead("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() {
        testHelper.removeTestFile(filePath);
    }
}

