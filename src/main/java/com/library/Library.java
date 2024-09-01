package com.library;

import java.util.HashMap;

import com.library.Exceptions.DuplicateBookException;

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

  /**
   * Adds a book to the library
   * 
   * @param newBook - The book to be added
   * @return - "Book added successfully."
   * @throws DuplicateBookException if a book with the same ISBN already exists
   * @throws NullPointerException   if newBook is null
   */
  public String addNewBook(Book newBook) {
    if (books.containsKey(newBook.getIsbn())) {
      throw new DuplicateBookException("Book with same ISBN already exists.");
    }
    books.put(newBook.getIsbn(), newBook);
    return "Book added successfully.";
  }

}
