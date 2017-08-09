package com.petitCookie.baggageClaim;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MemoryGame game = new MemoryGame();
        Sorting sorter = new Sorting();
        boolean running = true;
        while (running) {
            clearScreen();
            printMenu();
            int selection = getSelection();
            switch (selection) {
                case 0:
                    playGame(game, sorter);
                    break;
                case 1:
                    printHelpCredits();
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }

    private static void playGame(MemoryGame game, Sorting sorter) {
        boolean stillPlaying = true;
        int numberOfCountriesToMemorize = 3;
        while (stillPlaying) {
            clearScreen();
            game.showNEntries(numberOfCountriesToMemorize);
            clearScreen();
            sorter.playSorting();
            clearScreen();
            stillPlaying = game.getAnswer();
            numberOfCountriesToMemorize++;
        }
    }

    private static int getSelection() {
        System.out.print("Please select an option: ");
        return new Scanner(System.in).nextInt();
    }

    private static void printHelpCredits() {
        List<String> help = FileReader.readFile("data/help.txt");
        List<String> credits = FileReader.readFile("data/credits.txt");
        clearScreen();
        System.out.println("Help");
        for (String line : help) {
            System.out.println(line);
        }
        System.out.println("\nCredits");
        for (String line : credits) {
            System.out.println(line);
        }
        new Scanner(System.in).nextLine();
        // TODO: 2017.08.09.
    }

    private static void printMenu() {
        List<String> logo = FileReader.readFile("data/logo.txt");
        String[] options = {
                "Play",
                "Help/Credits",
                "Exit"
        };
        System.out.print(String.format("%c[1m", 0x1B));  // bold
        for (String line : logo) {
            System.out.println(line);
        }
        System.out.print(String.format("%c[0m", 0x1B));  // reset
        System.out.println();
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + ". " + options[i]);
        }
    }

    private static void clearScreen() {
        System.out.print(String.format("%c[2J", 0x1B));  // clear screen
        System.out.print(String.format("%c[3J", 0x1B));  // clear scrollback buffer
        System.out.print(String.format("%c[%d;%df", 0x1B, 1, 1));  // position cursor to 1,1
    }
}
