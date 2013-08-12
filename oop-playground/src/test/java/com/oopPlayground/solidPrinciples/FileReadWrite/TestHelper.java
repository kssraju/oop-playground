package com.oopPlayground.solidPrinciples.FileReadWrite;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestHelper {
    public void createTestFile(String filePath, String contents) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file.getAbsoluteFile());
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
