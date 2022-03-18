/*
Programming II Assignment 4
By: Erick Rivera
Due Date: March 20th, 2022
PID: 6311416
 */
package main;

import util.*;
import java.util.*;

public class PatternFinder {
    private static String randomStringGenerator(int length) {
        // generates a string made of randomly generated lowercase
        // letters.
        Random random = new Random(System.nanoTime());
        char[] array = new char[length];
        for (int i = 0; i < length; i++)
            array[i] = (char) ('a' + random.nextInt(26));
        return new String(array);
    }
    private static void singletonMiner(String mine, int length) throws SingletonException{
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++)
                if (mine.charAt(i) != mine.charAt(i - 1)) {
                    //System.out.println("Singleton " + length);
                    break;
                }
            if (i == start + length)
                throw new SingletonException(mine.substring(start, start + length), start);
        }
    }

    private static void arithmeticOneMiner (String mine, int length) throws ArithmeticOrderOne{
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            //Uses for loop to move along the length of the string while also calling the .compare method to
            //get a numerical evaluation of how far the characters are from one another.
            for (i = start + 1; i < start + length; i++)
                if (Character.compare(mine.charAt(i), mine.charAt(i-1)) != 1) {
                    //System.out.println("AOM " + length);
                    break;
                }
            if (i == start + length)
                throw new ArithmeticOrderOne(mine.substring(start, start + length), start);
        }
    }

    private static void arithmeticOneNegMiner (String mine, int length) throws ArithmeticOrderNegOne{
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            //Uses for loop to move along the length of the string while also calling the .compare method to
            //get a numerical evaluation of how far the characters are from one another.
            for (i = start + 1; i < start + length; i++)
                if (Character.compare(mine.charAt(i), mine.charAt(i-1)) != -1) {
                    //System.out.println("-AOM " + length);
                    break;
                }
            if (i == start + length)
                throw new ArithmeticOrderNegOne(mine.substring(start, start + length), start);
        }
    }

    private static void tripartiteMiner (String mine, int length) throws BalancedTripartite {
    //Substrings i into 3 different temporary placeholders (mine).
        for (int start = 0; start <= mine.length() - length; start++) {
            String mine1 = "", mine2 = "", mine3 = "";
            int third = length / 3;
            mine1 += mine.substring(start, (start + third));
            mine2 += mine.substring((start + third), start + (third * 2));
            mine3 += mine.substring(start + (third * 2), start + length);
            //System.out.println("TPS " + length);
            if (mine1.equals(mine2) && mine1.equals(mine3)) {
                throw new BalancedTripartite(mine.substring(start, start + length), start);
            }
        }
    }

    private static void bipartiteMiner (String mine, int length) throws BalancedBipartite {
        //Substrings i into 2 different temporary placeholders (mine).
        for (int start = 0; start <= mine.length() - length; start++) {
            String mine1 = "", mine2 = "";
            int half = length / 2;
            mine1 += mine.substring(start, (start + half));
            mine2 += mine.substring((start + half), start + length);
            //System.out.println("BPS " + length);
            if (mine1.equals(mine2)) {
                throw new BalancedBipartite(mine.substring(start, start + length), start);
            }
        }
    }

    private static void palindromeMiner (String mine, int length) throws Palindrome {
        //Substrings start + length into String originalMine and then compares i with its reverse starting at length.
        //Uses boolean system to verify if it's true.
        if (length == 1)
            throw new Palindrome(mine.substring(0, 0), 0);

        for (int start = 0; start <= mine.length() - length; start++) {
            String originalMine = "";

            for (int j = start; j < start + length; j++)
                originalMine += mine.charAt(j);
            //System.out.println(originalMine);

            boolean isPal = true;
            for (int i = 0; i < originalMine.length(); i++)
                if(originalMine.charAt(i) != originalMine.charAt(originalMine.length() - 1 - i))
                    isPal = false;
            if(isPal)
                throw new Palindrome(mine.substring(start, start + length), start);
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Step 1: handling input...
        System.out.println("Enter the maximum length of special patters between 3 - 15: ");
        int patternMaxLength = 0;
        //Receives user int and uses exception in case incorrect value or if characters were mistakenly used.
        while(true) {
            try {
                patternMaxLength = keyboard.nextInt();
                if(patternMaxLength < 3 || patternMaxLength > 15)
                    throw new NumberFormatException();
            }
            catch (InputMismatchException e) {
                keyboard.nextLine();
                System.out.println("Try again! Please remember to enter an integer!");
                continue;
            }
            catch (NumberFormatException e) {
                keyboard.nextLine();
                System.out.println("Try again! Remember the range must be between 3 - 15");
                continue;
            }
            break;
        }

        System.out.println("Enter the length of random string between 100,000 and 1,000,000,000: ");
        int randomStringLength = 0;
        //Receives user int and uses exception in case incorrect value or if characters were mistakenly used.
        while (true) {
            try {
                randomStringLength = keyboard.nextInt();
                if (randomStringLength < 100000 || randomStringLength > 1000000000)
                    throw new NumberFormatException();
            }
            catch (InputMismatchException e) {
                keyboard.nextLine();
                System.out.println("Try again! Please remember to enter an integer!");
                continue;
            }
            catch (NumberFormatException e) {
                keyboard.nextLine();
                System.out.println("Try again! Remember the range must be between 100,000 and 1,000,000,000");
                continue;
            }
            break;
        }
        //Step 2: generating random string...
        System.out.println("Creating new Random String...");
        String randomString = randomStringGenerator(randomStringLength);
        //Step 3: finding the interesting patterns
        try {
            for (int length = patternMaxLength; length > 0; length--) {
                System.out.println("Testing Singleton Miner at Length " + length + "...");
                singletonMiner(randomString, length);
                System.out.println("Testing Arithmetic One Miner at Length " + length + "...");
                arithmeticOneMiner(randomString, length);
                System.out.println("Testing Arithmetic Negative One Miner at Length " + length + "...");
                arithmeticOneNegMiner(randomString, length);
                if (length % 3 == 0)
                    System.out.println("Testing Balanced Tripartite Miner at Length " + length + "...");
                    tripartiteMiner(randomString, length);
                if (length % 2 == 0)
                    System.out.println("Testing Balanced Bipartite Miner at Length " + length + "...");
                    bipartiteMiner(randomString, length);
                System.out.println("Testing Palindrome Miner at Length " + length + "...");
                palindromeMiner(randomString, length);
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}
