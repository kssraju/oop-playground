package com.oopPlayground.solidPrinciples.FileReadWrite;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestHelper {
    public void createTestFile(String filePath, String contents) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(contents);

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTestFile(String filePath) {
        File file = new File(filePath);
        try {
            file.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
