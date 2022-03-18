package util;

public class Palindrome extends Exception {
    private String palindromeString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return palindromeString + " is a Palindrome string that is found at index " + occurrenceIndex + "!";
    }
    public Palindrome (String palindromeString, int index) {
        this.palindromeString = palindromeString;
        occurrenceIndex = index;
    }
}
