package lab7.compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gavrila Denisa
 */
public class Location {
    private boolean Visited = false;
    private List<Token> tokens = new ArrayList<>();

    public boolean isVisited() { return Visited; }
    public void visit() { Visited = true; }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
