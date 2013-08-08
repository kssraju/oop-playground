package com.oopPlayground.solidPrinciples.FileReadWrite;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

import static org.mockito.BDDMockito.*;

public class FileReadHandlerSpec {

    private static TestHelper testHelper;
    private static String filePath;

    @BeforeClass
    public static void initialize() {
        filePath = "/home/abhimanyu/Learning/OOP/SOLID/FileReadHandlerSpecFile.txt";
        testHelper = new TestHelper();
        testHelper.createTestFile(filePath, "Hello World!\nThis is a new line in the file");
    }

    @Test
    public void shouldReadFile() {
        String filePath = "/home/abhimanyu/Learning/OOP/SOLID/Sample.txt";

        FileOpenHandler openHandler = new FileOpenHandler();
        Reader reader = null;
        try {
            reader = openHandler.openForRead(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException in opening the file");
        }

        FileReadHandler readHandler = new FileReadHandler(reader);

        String contents = readHandler.readAllLines();

        Assert.assertFalse(contents.equals(""));
    }

    @AfterClass
    public static void tearDown() {
        testHelper.removeTestFile(filePath);
    }
}

