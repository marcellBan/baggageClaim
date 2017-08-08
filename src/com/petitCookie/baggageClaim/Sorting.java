package com.petitCookie.baggageClaim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorting {

    List<String> fullList = new ArrayList<>();


    public Sorting(){
        fullList = FileReader.readFile("random.txt");
    }

    public void playSorting() {
        List<String> words = createWordList();


    }

    private List createWordList() {
        List<String> selectedWords = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int len = fullList.size();
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(len);
            selectedWords.add(fullList.get(randomInt));
        }
        Collections.shuffle(selectedWords);

        return selectedWords;
    }

}
