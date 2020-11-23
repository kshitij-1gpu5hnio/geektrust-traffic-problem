package com.geektrust.traffic.exceptions;

/**
 * This class is a wrapper over exception.
 * This is used when an input file path is not passed in the argument.
*/
public class FilePathException extends Throwable {
    public FilePathException() {
        super("File path not passed, please pass a valid path for input file.");
    }

    public FilePathException(String message) {
        super(message);
    }
}
