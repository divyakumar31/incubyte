package com.library.Exceptions;

/**
 * Custom exception class for book not found
 */
public class BookNotFoundException extends RuntimeException {

  /**
   * @param message - The message to be displayed
   */
  public BookNotFoundException(String message) {
    super(message);
  }
}
