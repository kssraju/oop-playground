package com.oopPlayground.solidPrinciples.FileReadWrite;

import org.junit.*;

import java.io.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class FileWriteHandlerSpec {

    private FileReadHandler readHandler;
    private String fileContents;
    private FileOpenHandler openHandler;

    private static TestHelper testHelper;
    private static String filePath;

    @BeforeClass
    public static void initialize() {
        filePath = "/home/abhimanyu/Learning/OOP/SOLID/FileWriteHandlerSpecFile.txt";
        testHelper = new TestHelper();
        testHelper.createTestFile(filePath, "Hello World!\nThis is a new line in the file");
    }


    @Before
    public void setup() {
        openHandler = new FileOpenHandler();
        readHandler = mock(FileReadHandler.class);
        given(readHandler.readAllLines()).willReturn("Hello World!\nThis is a new line in the file");
        fileContents = readHandler.readAllLines();
    }

    @Test
    public void shouldWriteContentsToFile() {
        Writer writer = null;
        try {
            writer = openHandler.openForWrite(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException in opening file");
        }
        IFileWriterHandler writeHandler = new FileWriterHandler(writer);
        writeHandler.writeAllLines(fileContents);
        assertFileContents(fileContents, filePath);
    }

    @Test
    public void shouldWriteFirstLineToFile() {
        FileOpenHandler openHandler = new FileOpenHandler();
        Writer writer = null;
        try {
            writer = openHandler.openForWrite(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException in opening file");
        }
        IFileWriterHandler writeHandler = new FileWriterHandler(writer);
        writeHandler.writeFirstLines(fileContents, 1);
        assertFileContents(fileContents, filePath);
    }

    private boolean assertFileContents(String contents, String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            int count = 0;
            StringBuilder content = new StringBuilder();

            while ((count = bufferedReader.read()) != -1) {
                content.append((char) count);
            }

            bufferedReader.close();
            reader.close();

            return contents.equals(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return false;
        }
    }

    @After
    public void tearDown() {
        readHandler = null;
        fileContents = "";
    }

    @AfterClass
    public static void destroy() {
        testHelper.removeTestFile(filePath);
    }
}

