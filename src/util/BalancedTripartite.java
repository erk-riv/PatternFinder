package util;

public class BalancedTripartite extends Exception {
    private String TripartiteString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return TripartiteString + " is a Balanced Tripartite string that is found at index " + occurrenceIndex + "!";
    }
    public BalancedTripartite(String TripartiteString, int index) {
        this.TripartiteString = TripartiteString;
        occurrenceIndex = index;
    }
}
