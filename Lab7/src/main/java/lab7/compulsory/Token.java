package lab7.compulsory;

/**
 * @author Gavrila Denisa
 */
public class Token {
    private final int number;

    public Token(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public int getNumber() {
        return number;
    }
}
