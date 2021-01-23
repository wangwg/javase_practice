package com.xiaogang.test;

import java.io.FileOutputStream;

/**
 * xiaOgang
 */
public class Test {
    public static void main(String[] args) throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream("text.txt");
        fileOutputStream.write("123".getBytes());
        //fileOutputStream.write(10);
        //fileOutputStream.write(95);
        //fileOutputStream.write(1);

        fileOutputStream.close();

    }
}













