package com.library;

import java.util.HashMap;

/**
 * Library class
 * - Manages the books in the library
 */
public class Library {
  private HashMap<String, Book> books;

  /**
   * Create an empty library
   */
  public Library() {
    books = new HashMap<>();
  }

  /**
   * Create a library with a single book
   * 
   * @param book
   */
  public Library(Book book) {
    books = new HashMap<>();
    books.put(book.getIsbn(), book);
  }

  // getter
  public HashMap<String, Book> getBooks() {
    return books;
  }
}
