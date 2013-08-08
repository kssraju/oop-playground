package com.oopPlayground.solidPrinciples.FileReadWrite;

import org.junit.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ConsoleWriteHandlerSpec {
    private FileReadHandler readHandler;
    private String fileContents;

    private static TestHelper testHelper;
    private static String filePath;

    @BeforeClass
    public static void initialize() {
        filePath = "/home/abhimanyu/Learning/OOP/SOLID/ConsoleWriteHandlerSpecFile.txt";
        testHelper = new TestHelper();
        testHelper.createTestFile(filePath, "Hello World!\nThis is a new line in the file");
    }

    @Before
    public void setup() {
        readHandler = mock(FileReadHandler.class);
        given(readHandler.readAllLines()).willReturn("Hello World!\nThis is a new line in the file");
        fileContents = readHandler.readAllLines();
    }

    @Test
    public void shouldPrintContentsOnConsole() {
        IFileWriterHandler writeHandler = new ConsoleWriterHandler();
        writeHandler.writeAllLines(fileContents);
    }

    @Test
    public void shouldPrintFirstLineOnConsole() {
        IFileWriterHandler writeHandler = new ConsoleWriterHandler();
        writeHandler.writeFirstLines(fileContents, 1);
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
