package cn.crowdos.demo.service.exceptions;

public class CommunicationException extends RuntimeException {
    public CommunicationException() {
        super("Generic Erlang Error");
    }
    public CommunicationException(String message) {
        super(message);
    }
}
