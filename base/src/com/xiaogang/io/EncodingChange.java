package com.xiaogang.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EncodingChange {

    public static void main(String[] args) {

        InputStreamReader streamReader = null;
        OutputStreamWriter streamWriter = null;

        try {
            streamReader = new InputStreamReader(new FileInputStream("a.txt"), "utf-8");
            streamWriter = new OutputStreamWriter(new FileOutputStream("a-gbk.txt"), "gbk");
            char[] buffered = new char[1024];
            int len;
            while ((len = streamReader.read(buffered)) > 0) {
                streamWriter.write(buffered, 0, len);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if (streamReader != null) {
                    streamReader.close();
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (streamWriter != null) {
                    streamWriter.close();
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
