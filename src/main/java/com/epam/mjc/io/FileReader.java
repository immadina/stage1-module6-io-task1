package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[10];
            StringBuilder sb = new StringBuilder();

            while (fileInputStream.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }

            String st = sb.toString().replace("\n", ":").replace(" ", "");
            String[] ar = st.split(":");

            for (int i = 0; i < ar.length; i++) {

                if (ar[i].equals("Name")) {
                    name = ar[i + 1];
                } else if (ar[i].equals("Age")) {
                    age = Integer.parseInt(ar[i + 1]);
                } else if (ar[i].equals("Email")) {
                    email = ar[i + 1];
                } else if (ar[i].equals("Phone")) {
                    phone = Long.parseLong(ar[i + 1]);
                }
            }

        } catch (IOException e) {
            System.err.print(e);
        }

        return new Profile(name, age, email, phone);

    }
}
