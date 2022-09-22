package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String absolutePath = "src/main/resources/Profile.txt"; //directory + File.separator + fileName;
        String name = "n";
        Integer age = 0;
        String email = "e";
        Long phone = 1111L;

        /*
        try (FileInputStream fileInputStream = new FileInputStream(absolutePath)) {
            int ch;
            char st;
            while ((ch=fileInputStream.readln()) != -1) {
                System.out.print((char)ch);
                st += (char)ch;
                name = Integer.toString(ch);


            }
        }
        */

        try (FileInputStream fis = new FileInputStream(absolutePath)) {

            int i = 0;

            do {

                byte[] buf = new byte[1024];
                i = fis.read(buf);

                String value = new String(buf);
                System.out.println(value);

                String[] val = value.split(" ");
                System.out.print(val);
            } while (i != -1);


        }


        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        }
        return new Profile(name, age, email, phone);
    }
}
