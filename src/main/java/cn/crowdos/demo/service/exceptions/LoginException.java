package cn.crowdos.demo.service.exceptions;

public class LoginException extends RuntimeException {

    public LoginException() {
        super("There was an error during login");
    }
    public LoginException(String message) {
        super(message);
    }
}
