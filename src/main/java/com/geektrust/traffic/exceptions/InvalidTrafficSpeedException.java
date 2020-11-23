package com.geektrust.traffic.exceptions;

public class InvalidTrafficSpeedException extends Throwable{
    public InvalidTrafficSpeedException() {
        super("Invalid traffic speed. Traffic speed should be greater than 0.");
    }

    public InvalidTrafficSpeedException(String message) {
        super(message);
    }
}
