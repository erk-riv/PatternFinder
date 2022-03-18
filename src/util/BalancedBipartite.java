package util;

public class BalancedBipartite extends Exception {
    private String BipartiteString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return BipartiteString + " is a Balanced Bipartite string that is found at index " + occurrenceIndex + "!";
    }
    public BalancedBipartite(String TripartiteString, int index) {
        this.BipartiteString = TripartiteString;
        occurrenceIndex = index;
    }
}
