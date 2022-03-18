package util;

public class ArithmeticOrderOne extends Exception {
    private String ArithmeticOrderOneString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return ArithmeticOrderOneString + " is a Arithmetic Order One string that is found at index " + occurrenceIndex + "!";
    }
    public ArithmeticOrderOne (String ArithmeticOrderOneString, int index) {
        this.ArithmeticOrderOneString = ArithmeticOrderOneString;
        occurrenceIndex = index;
    }
}
