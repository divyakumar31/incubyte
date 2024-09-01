package com.library.Exceptions;

/**
 * Custom exception class for book not available
 */
public class BookNotAvailableException extends RuntimeException {

  /**
   * @param message - The message to be displayed
   */
  public BookNotAvailableException(String message) {
    super(message);
  }
}
