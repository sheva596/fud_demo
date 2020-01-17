package com.centerm.fud_demo.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);

        if (!targetFile.exists()) {
            targetFile.mkdir();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);

        out.write(file);
        out.flush();
        out.close();
    }
}