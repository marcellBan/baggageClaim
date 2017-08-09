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
        System.out.println("You failed!\nPress Enter to return to the main menu.");
        new Scanner(System.in).nextLine();
    }

    private static int getSelection() {
        System.out.print("Please select an option: ");
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt()){
            input.next();
            System.out.print("Please select an option: ");
        }
        return input.nextInt();

    }

    private static void printHelpCredits() {
        List<String> help = FileReader.readFile("data/help.txt");
        List<String> credits = FileReader.readFile("data/credits.txt");
        clearScreen();
        System.out.print(String.format("%c[1m", 0x1B));  // bold
        System.out.println("Help");
        System.out.print(String.format("%c[0m", 0x1B));  // reset
        for (String line : help) {
            System.out.println(line);
        }
        System.out.print(String.format("%c[1m", 0x1B));  // bold
        System.out.println("\nCredits");
        System.out.print(String.format("%c[0m", 0x1B));  // reset
        for (String line : credits) {
            System.out.println(line);
        }
        System.out.println("\nPress Enter to return to the main menu.");
        new Scanner(System.in).nextLine();
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
