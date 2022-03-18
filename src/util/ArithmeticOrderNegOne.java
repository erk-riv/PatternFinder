package util;

public class ArithmeticOrderNegOne extends Exception {
    private String ArithmeticNegOneString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return ArithmeticNegOneString + " is a Arithmetic Order Negative One string that is found at index " + occurrenceIndex + "!";
    }
    public ArithmeticOrderNegOne (String ArithmeticNegOneString, int index) {
        this.ArithmeticNegOneString = ArithmeticNegOneString;
        occurrenceIndex = index;
    }
}
