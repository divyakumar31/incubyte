package com.library;

import java.time.Year;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Book class
 * 
 * @author DIVYAKUMAR PATEL
 * @version 1.0
 */
public class Book {
  private String title;
  private String author;
  private String isbn;
  private int publicationYear;
  private boolean isAvailable;

  /**
   * Book constructor
   * 
   * @param title           defines the title of the book
   * @param author          defines the author of the book
   * @param isbn            defines the isbn of the book
   * @param publicationYear defines the publication year of the book
   */
  public Book(String title, String author, String isbn, int publicationYear) {
    if (title == null || author == null || isbn == null) {
      throw new NullPointerException("Title, author, and ISBN cannot be null");
    }
    if (title.equals("") || author.equals("") || isbn.equals("")) {
      throw new IllegalArgumentException("Title, author, and ISBN cannot be empty");
    }
    if (publicationYear < 0 || publicationYear > Year.now().getValue()) {
      throw new IllegalArgumentException("Publication year cannot be negative or in the future");
    }
    if (!isValidIsbn(isbn)) {
      throw new IllegalArgumentException("ISBN should be the length of 13.");
    }
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.publicationYear = publicationYear;
    this.isAvailable = true;
  }

  // Getters and Setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    if (title == null) {
      throw new NullPointerException("Title cannot be null");
    }
    if (title.equals("")) {
      throw new IllegalArgumentException("Title cannot be empty");
    }
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    if (author == null) {
      throw new NullPointerException("Author cannot be null");
    }
    if (author.equals("")) {
      throw new IllegalArgumentException("Author cannot be empty");
    }
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    if (isbn == null) {
      throw new NullPointerException("ISBN cannot be null");
    }
    if (isbn.equals("")) {
      throw new IllegalArgumentException("ISBN cannot be empty");
    }
    this.isbn = isbn;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int publicationYear) {
    if (publicationYear < 0 || publicationYear > Year.now().getValue()) {
      throw new IllegalArgumentException("Publication year cannot be negative or in the future");
    }
    this.publicationYear = publicationYear;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public boolean isValidIsbn(String isbn) {
    Pattern pattern = Pattern.compile("^[0-9]{3}[- ][0-9]{2}[- ][0-9]{3}[- ][0-9]{4}[- ][0-9]$",
        Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(isbn);
    return matcher.matches();
  }
}
