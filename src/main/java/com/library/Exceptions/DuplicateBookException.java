package com.library.Exceptions;

/**
 * Custom exception class for duplicate book
 */
public class DuplicateBookException extends RuntimeException {
  /**
   * 
   * @param message - The message to be displayed
   */
  public DuplicateBookException(String message) {
    super(message);
  }
}