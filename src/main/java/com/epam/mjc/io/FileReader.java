package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;


public class FileReader {

    public Profile getDataFromFile(File file) {
        //String absolutePath = "src/main/resources/Profile.txt"; //directory + File.separator + fileName;
        String name = "n";
        Integer age = 0;
        String email = "e";
        Long phone = 1L;

        FileInputStream fis = null;
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        try {
            fis = new FileInputStream(file);

            while (fis.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        String st = sb.toString().replace("\n", ":").replace(" ", "");
        String[] ar = st.split(":");

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
            if (ar[i].equals("Name")) {
                name = ar[i+1];
                System.out.println("Here");
            } else if (ar[i].equals("Age")) {
                age = Integer.parseInt(ar[i+1]);
            } else if (ar[i].equals("Email")) {
                email = ar[i+1];
            } else if (ar[i].equals("Phone")) {
                phone = Long.parseLong(ar[i+1]);
            }
        }
        //System.out.println(ar);
        return new Profile(name, age, email, phone);
    }
}
