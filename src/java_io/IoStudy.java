package java_io;

import java.io.*;

public class IoStudy {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "F:\\java代码集合\\DatabaseAndSort\\DatabaseAndSort\\README.md";
        File file = new File(path);
        System.out.println(file.length());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getTotalSpace());
    }
}
