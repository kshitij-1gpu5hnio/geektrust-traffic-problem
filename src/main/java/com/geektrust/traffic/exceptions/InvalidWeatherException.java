package com.geektrust.traffic.exceptions;

/**
 * This class is wrapper over exception.
 * This is used when an invalid weather type is passed in the input file.
*/
public class InvalidWeatherException extends Throwable {
    public InvalidWeatherException() {
        super("Invalid Weather. Acceptable types are SUNNY, RAINY, WINDY.");
    }

    public InvalidWeatherException(String message) {
        super(message);
    }
}
