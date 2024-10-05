package exception_handling;

public class InvalidCustomerNumberException extends Exception {
    public InvalidCustomerNumberException(String message) {
        super(message);
    }
}
