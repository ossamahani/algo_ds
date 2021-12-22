package algo.ds.Interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * * REQUIREMENTS *
 * =====================================================================================
 * * - Given a starting word, "RACECAR" * - Allow user to input a single
 * character at a time on the command line * - After every user input, respond
 * to the user with: * The current status of the word (R _ C E C _ R) * - The
 * failed or all characters they have already tried (U I S O) * - And, most
 * importantly, how many attempts they have left till getting HANGED! * - Extra
 * Credit (if already solved the above): * - Instead of using a static word at
 * the start, pick a random word from a given list
 * 
 */

public class Game {

    private static final int hangCount = 6;

    public static void main(String[] args) {
        String startingWord = "RACECAR";
        hangMan(startingWord);
    }

    public static void hangMan(String startingWord) {
        int failedCount = 0;
        int lenOfUnique = getUniqueLetters(startingWord);
        int noOfAttempts = lenOfUnique + hangCount;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < startingWord.length(); i++) {
            sb.append('-');
        }
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < noOfAttempts; i++) {
           
            System.out.print("Enter a letter: ");
            // Check that user entered single character
            String str = input.nextLine();
            if(str.length() > 1) {
                System.out.println("Please enter single character");
            }
            if(str.length() == 0) {
                System.out.println("Input is blank");
                 i--;
                continue;
            }
            char ch = str.charAt(0);
            // if Character matches the word
            boolean isExist = checkUserInput(ch, startingWord, sb);
            System.out.println(sb.toString());
            if (!isExist) { 
               failedCount++;
            }

            if (sb.toString().equalsIgnoreCase(startingWord)) {
                System.out.println("You Won!!");
                input.close();
                break;
            }

            if (failedCount == hangCount) {
                System.out.println("Failed Attemps: " + failedCount);
                System.out.println("You Hanged!!");
                input.close();
                break;
            }

            System.out.println("Failed Attemps: " + failedCount);
        }
    }

    // R RACECARE
    public static boolean checkUserInput(char ch, String word, StringBuffer sb) {
        boolean isExist = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                sb.setCharAt(i, ch);
                isExist = true;
            }
        }
        return isExist;
    }

    public static int getUniqueLetters(String word) {
        Set<Character> set = new HashSet<>();
        for (char ch : word.toCharArray()) {
            set.add(ch);
        }
        return set.size();
    }

}
