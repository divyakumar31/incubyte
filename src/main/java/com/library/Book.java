package com.library;

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
    if (publicationYear < 0) {
      throw new IllegalArgumentException("Publication year cannot be negative");
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
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int publicationYear) {
    this.publicationYear = publicationYear;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

}
