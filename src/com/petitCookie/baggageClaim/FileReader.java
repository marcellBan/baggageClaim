package com.petitCookie.baggageClaim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List readFile(String fileName) {
        List<String> result = new ArrayList<>();
        try {
            Scanner data = new Scanner(new File(fileName));
            while (data.hasNextLine()) {
                result.add(data.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
        return result;
    }

}
