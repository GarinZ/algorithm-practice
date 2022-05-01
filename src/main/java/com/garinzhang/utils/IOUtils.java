package com.garinzhang.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Zhang Jialin
 * @date 2022-05-01
 */
public class IOUtils {

    public static String getTestResourceFileContent(String fileName) throws IOException {
        String path = "src/test/resources/" + fileName;
        File file = new File(path);
        long fileLength = file.length();
        byte[] fileContent = new byte[(int) fileLength];
        try (FileInputStream in = new FileInputStream(file)) {
            in.read(fileContent);
        }
        return new String(fileContent, StandardCharsets.UTF_8);
    }
}
