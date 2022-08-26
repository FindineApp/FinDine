package com.example.findine;

import android.content.Context;

import java.io.File;
import java.util.Objects;

public class CacheActions {

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public long getDirSize(File dir){
        long size = 0;
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file != null && file.isDirectory()) {
                size += getDirSize(file);
            } else if (file != null && file.isFile()) {
                size += file.length();
            }
        }
        return size;
    }

    public String convertSize(int size) {
        String convertedSize = size + " B";
        if (size >= 1000) {
            size = size / 1000;
            convertedSize = size + " KB";
            if (size >= 1000000) {
                size = size / 1000000;
                convertedSize = size + " MB";
            }
        }
        return convertedSize;
    }
}
