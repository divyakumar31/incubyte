package com.library;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  private static Library library;

  public static void main(String[] args) {
    System.out.println("\n\nHello Welcome to Library Management System!\n\n");
    Scanner scanner = new Scanner(System.in);
    library = new Library();
    while (true) {

      System.out.println(
          "\n************\nEnter 1 to add book\nEnter 2 to borrow book\nEnter 3 to return book\nEnter 4 to view available books\nEnter 5 to exit\n************\n");

      int choice = scanner.nextInt();

      if (choice == 5) {
        break;
      }

      switch (choice) {
        case 1:
          System.out.println("Enter book title: ");
          scanner.nextLine();
          String title = scanner.nextLine();
          System.out.println("Enter book author: ");
          String author = scanner.nextLine();
          System.out.println("Enter book ISBN: ");
          String ISBN = scanner.nextLine();
          System.out.println("Enter book publication year: ");
          int publicationYear = scanner.nextInt();
          try {
            Book book = new Book(title, author, ISBN, publicationYear);
            String returnMessage = library.addNewBook(book);
            System.out.println(returnMessage);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;

        case 2:
          System.out.println("Enter book ISBN: ");
          scanner.nextLine();
          String ISBN2 = scanner.nextLine();
          try {
            Book book = library.borrowBook(ISBN2);
            System.out.println("Book named " + book.getTitle() + " borrowed successfully.");
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;

        case 3:
          System.out.println("Enter book ISBN: ");
          scanner.nextLine();
          String ISBN3 = scanner.nextLine();
          try {
            String returnMessage = library.returnBorrowedBook(ISBN3);
            System.out.println(returnMessage);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;

        case 4:
          ArrayList<Book> books = library.availableBooks();
          if (books.size() == 0) {
            System.out.println("No available books");
          } else {
            for (Book book : books) {
              System.out.println(book.getTitle());
            }
          }
          break;

        default:
          System.out.println("Invalid choice");
          break;
      }
    }
    scanner.close();
  }
}