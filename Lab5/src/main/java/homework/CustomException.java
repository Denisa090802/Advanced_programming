package homework;

public class CustomException extends RuntimeException {
    /**
     * @param errorMessage
     */
    public CustomException(String errorMessage) {
        super("Error running command " + errorMessage);
    }
}
