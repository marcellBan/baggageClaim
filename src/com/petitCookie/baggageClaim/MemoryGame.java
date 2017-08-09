package com.petitCookie.baggageClaim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    private List<String> allData;
    private List<String> selected;

    public MemoryGame() {
        allData = FileReader.readFile("data/countries.txt");
        selected = new ArrayList<>();
    }

    public void showNEntries(int n) {
        selected.clear();
        Collections.shuffle(allData);
        System.out.println("Memorize these countries!");
        for (int i = 0; i < n; i++) {
            selected.add(allData.get(i));
            System.out.println(selected.get(i));
        }
        System.out.println("Press Enter when you are ready!");
        new Scanner(System.in).nextLine();
    }

    public boolean getAnswer() {
        System.out.println("Select the countries you memorized!");
        int fullSize = selected.size() + 3;
        List<String> extendedSelection = new ArrayList<>(fullSize);

        for (int i = 0; i < fullSize; i++) {
            extendedSelection.add(allData.get(i));
        }
        Collections.shuffle(extendedSelection);

        for (int i = 0; i < fullSize; i++) {
            System.out.println(i + ". " + extendedSelection.get(i));
        }
        System.out.println("Select the countries shown before by entering the numbers separated by commas!");

        String userInput = new Scanner(System.in).nextLine();
        String[] indexes = userInput.split(",");

        if (indexes.length != selected.size()) {
            return false;
        }
        for (String i : indexes) {
            int index = Integer.parseInt(i);
            if (!selected.contains(extendedSelection.get(index))) {
                return false;
            }
        }
        return true;
    }
}
