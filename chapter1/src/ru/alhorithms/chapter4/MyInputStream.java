package ru.alhorithms.chapter4;

import java.io.*;
import java.util.Scanner;

public class MyInputStream {
    private Scanner scanner;
    File file;


    MyInputStream(String string) throws IOException {
        file = new File(string);
        scanner = new Scanner(file);
    }

    public int read() {
        try {
            if (!scanner.hasNext()) scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scanner.nextInt();
    }

    public boolean hasNextLine() {
        if (scanner.hasNextLine()) return true;
        return false;
    }

    public int size() {return (int)file.length();}

    public String readLine() {return scanner.nextLine();}
}
