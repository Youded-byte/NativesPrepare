package me.youded.NativesPrepare;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class extractNatives {
    public static void extractNativeFiles(String args) {
        File nativesDir = new File(args);

        if (!nativesDir.exists()) {
            nativesDir.mkdirs();
            FileInputStream fileInputStream;
            // buffer to read and write data in the file
            byte[] buffer = new byte[1024];
            try {
                fileInputStream = new FileInputStream(args + ".zip");
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                ZipEntry zEntry = zipInputStream.getNextEntry();
                while (zEntry != null) {
                    String fileName = zEntry.getName();
                    File newFile = new File(args + File.separator + fileName);
                    new File(newFile.getParent()).mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                    int len;
                    while ((len = zipInputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    fileOutputStream.close();
                    // close this ZipEntry
                    zipInputStream.closeEntry();
                    zEntry = zipInputStream.getNextEntry();
                }
                // close last ZipEntry
                zipInputStream.closeEntry();
                zipInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}