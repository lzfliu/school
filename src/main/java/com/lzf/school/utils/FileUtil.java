package com.lzf.school.utils;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        String targetFileName = getTargetFileName(fileName);
        FileOutputStream out = new FileOutputStream(filePath+targetFileName);
        out.write(file);
        out.flush();
        out.close();
    }

    private static String getTargetFileName(String fileName) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timestamp = sdf.format(date);
        String targetFileName = fileName.substring(0,fileName.lastIndexOf("."));
        String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        targetFileName = targetFileName + timestamp + suffix;
        return targetFileName;
    }


    public static void main(String[] args) {
        String fileName = "abc.txt";
        String targetFileName = fileName.substring(0,fileName.lastIndexOf("."));
        String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        System.out.println(targetFileName);
        System.out.println(suffix);
    }

}
