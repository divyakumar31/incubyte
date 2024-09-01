package com.library;

import java.util.HashMap;

import com.library.Exceptions.BookNotAvailableException;
import com.library.Exceptions.BookNotFoundException;
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

  /**
   * Borrows a book from the library
   * 
   * @param isbn - The ISBN of the book to be borrowed
   * @return - The borrowed book
   * @throws BookNotFoundException     if the book with the given ISBN is not
   *                                   found in the library
   * @throws BookNotAvailableException if the book with the given ISBN is not
   *                                   available to borrow.
   */
  public Book borrowBook(String isbn) {
    if (books.containsKey(isbn)) {
      Book book = books.get(isbn);
      if (book.isAvailable()) {
        book.setAvailable(false);
        return book;
      } else {
        throw new BookNotAvailableException("Book is not available to borrow.");
      }
    }
    throw new BookNotFoundException("Book not found in library.");
  }

  /**
   * Returns a borrowed book to the library
   * 
   * @param isbn - The ISBN of the book to be returned
   * @return - "Book returned to library successfully."
   * @throws BookNotFoundException if the book with the given ISBN is not found in
   *                               the books list of the library
   */
  public String returnBorrowedBook(String isbn) {
    if (books.containsKey(isbn)) {
      Book book = books.get(isbn);
      book.setAvailable(true);
      return "Book returned to library successfully.";
    }
    throw new BookNotFoundException("You can not return a book that is not in the books list of the library.");
  }

}
