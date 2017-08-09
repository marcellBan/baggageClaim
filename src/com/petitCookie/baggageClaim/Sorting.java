package com.petitCookie.baggageClaim;

import java.util.*;

public class Sorting {

    List<String> fullList = new ArrayList<>();


    public Sorting(){
        fullList = FileReader.readFile("data/random.txt");
    }


    public void playSorting() {
        List<String> words = createWordList();
        List<Integer> result = new ArrayList<>(createResultList(words));
        String[] userAnswer;
        do {
            userAnswer = getUserAnswer(words);
        }while( !checkUserAnswer(userAnswer, result));
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

    private List createResultList(List originalWords) {
        List<String> sortedWords = new ArrayList<>(originalWords);
        List<Integer> result = new ArrayList<>();
        Collections.sort(sortedWords);
        for (int i = 0; i < sortedWords.size(); i++) {
            result.add(originalWords.indexOf(sortedWords.get(i)));
        }
        return result;
    }


    private String[] getUserAnswer(List wordsToSort) {
        Scanner userAnswer = new Scanner(System.in);
        for (Object word : wordsToSort) {
            System.out.println(wordsToSort.indexOf(word) + " " + word);
        }
        String answer, temp;
        do {
            System.out.print("Enter numbers in the right order (separated by space): ");
            answer = userAnswer.nextLine();
            temp = answer.replaceAll(" ", "");
        } while (!(temp.length() == 6 && new Scanner(temp).hasNextInt()));
        String[] numbers = answer.split(" ");
        return  numbers;
    }


    private boolean checkUserAnswer(String[] answers, List correctAnswers) {
       for (int i = 0; i < answers.length; i++) {
           Integer number = new Integer(answers[i]);
           if (!number.equals(correctAnswers.get(i))) {
             return false;
           }
       }
       return true;
    }


}
