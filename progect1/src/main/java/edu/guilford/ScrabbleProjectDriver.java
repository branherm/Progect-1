package edu.guilford;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleProjectDriver {
    public static void main(String[] args) {
        // Instantiate two ScrabbleSet objects
        ScrabbleSet standardSet = new ScrabbleSet("English");
        ScrabbleSet randomSet = new ScrabbleSet();

        // Print each ScrabbleSet to examine correctness
        System.out.println("Standard Scrabble Set:");
        System.out.println(standardSet);
        System.out.println("Random Scrabble Set:");
        System.out.println(randomSet);

        // Test word scoring for 25 words
        ArrayList<String> testWords = new ArrayList<>();
        testWords.add("HELLO");
        testWords.add("WORLD");
        testWords.add("JAVA");
        testWords.add("PYTHON");
        testWords.add("SCRABBLE");
        testWords.add("ZEBRA");
        testWords.add("DOG");
        testWords.add("CAT");
        testWords.add("EQUATION");
        testWords.add("SCIENCE");
        testWords.add("QUIZ");
        testWords.add("HELLO123");
        testWords.add("INVALID!");
        testWords.add("Exquisitely");
        testWords.add("Dizzy");
        testWords.add("SPARK");
        testWords.add("COMPUTER");
        testWords.add("PRINTER");
        testWords.add("PLANE");
        testWords.add("BICYCLE");
        testWords.add("ARTIFICIAL");
        testWords.add("INTELLIGENCE");
        testWords.add("BOOK");
        testWords.add("GENIUS");
        testWords.add("INVALIDWORD!");

        System.out.println("\nTesting word scores with the standard set:");
        for (String word : testWords) {
            System.out.printf("Word: %-15s Score: %d\n", word, standardSet.getWordScore(word));
        }
        // Evaluate words in frankenstein.txt
        // try {
        //ArrayList<String> words = new ArrayList<>();
        //BufferedReader reader = new BufferedReader(new FileReader("progect1/src/main/resources/frankenstein.txt"));
        //String line;

        //while ((line = reader.readLine()) != null) {
       //     words.add(line.trim());
        //}
        //reader.close();

        //String highestScoringWord = "";
        //int highestScore = 0;
        //String shortestInvalidWord = "";
        //int shortestLength = Integer.MAX_VALUE;

       // for (String theLine : words) {
            //String[] lineWords = theLine.split(" ");
           // for (String word : lineWords) {
              //  int score = standardSet.getWordScore(word);
                //System.out.println(word + ": " + score);

                // Check for highest scoring word
               // if (score > highestScore) {
               //     highestScoringWord = word;
               //     highestScore = score;
               // }

                // Check for shortest invalid word
                //if (score == -1 && word.matches("[a-zA-Z]+") && word.length() < shortestLength) {
                   // shortestInvalidWord = word;
                   // shortestLength = word.length();
               // }
           // }
       // }

      //  System.out.println("\nAnalysis of frankenstein.txt:");
       // System.out.println("Highest scoring word: " + highestScoringWord + " (Score: " + highestScore + ")");
       // System.out.println("Shortest invalid word: " + shortestInvalidWord);

        // } catch (IOException e) {
       // System.err.println("Error reading frankenstein.txt: " + e.getMessage());
        // }

        // Evaluate with the random Scrabble set
        try {
            ArrayList<String> words = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("progect1/src/main/resources/frankenstein.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
            reader.close();

            String highestScoringWord = "";
            int highestScore = 0;
            String shortestInvalidWord = "";
            int shortestLength = Integer.MAX_VALUE;

            for (String theLine : words) {
                String[] lineWords = theLine.split(" ");
                for (String word : lineWords) {
                    int score = randomSet.getWordScore(word);
                    System.out.println(word + ": " + score);

                    // Check for highest scoring word
                    if (score > highestScore) {
                        highestScoringWord = word;
                        highestScore = score;
                    }

                    // Check for shortest invalid word
                    if (score == -1 && word.matches("[a-zA-Z]+") && word.length() < shortestLength) {
                        shortestInvalidWord = word;
                        shortestLength = word.length();
                    }

                }
            }

            System.out.println("\nAnalysis of frankenstein.txt with random set:");
            System.out.println("Highest scoring word: " + highestScoringWord + " (Score: " + highestScore + ")");
            System.out.println("Shortest invalid word: " + shortestInvalidWord);
        } catch (IOException e) {
            System.err.println("Error reading frankenstein.txt: " + e.getMessage());
        }

        // User input loop
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter words to calculate Scrabble scores. Type 'EXIT' to quit.");
        while (true) {
            System.out.print("Enter a word: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            int standardScore = standardSet.getWordScore(input);
            int randomScore = randomSet.getWordScore(input);

            if (standardScore == -1) {
                System.out.println("Invalid word.");
            } else {
                System.out.println("Standard Set Score: " + standardScore);
            }

            if (randomScore == -1) {
                System.out.println("Invalid word in random set.");
            } else {
                System.out.println("Random Set Score: " + randomScore);
            }
        }

        scanner.close();
        {
        }

    }
}
