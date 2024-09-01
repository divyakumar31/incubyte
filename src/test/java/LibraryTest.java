import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import com.library.Book;
import com.library.Library;
import com.library.Exceptions.BookNotAvailableException;
import com.library.Exceptions.BookNotFoundException;
import com.library.Exceptions.DuplicateBookException;

public class LibraryTest {

  private Book book;
  private Library library;

  @Before
  public void setup() {
    library = new Library();
    book = new Book("MyBook", "DP", "978 90 274 3964 2", 2024);
  }

  @Test
  public void testLibrary() {
    assertEquals(0, library.getBooks().size());

    Library library2 = new Library(book);
    assertEquals(1, library2.getBooks().size());
    assertEquals(book, library2.getBooks().get("978 90 274 3964 2"));
  }

  @Test
  public void testAddNewBook() {
    String returnMessage = library.addNewBook(book);
    assertEquals(1, library.getBooks().size());
    assertEquals(book, library.getBooks().get("978 90 274 3964 2"));
    assertEquals("Book added successfully.", returnMessage);

    // Add same book
    assertThrows(DuplicateBookException.class, () -> {
      library.addNewBook(book);
    });

    assertEquals(1, library.getBooks().size());

    // Add null book
    assertThrows(NullPointerException.class, () -> {
      library.addNewBook(null);
    });

    assertEquals(1, library.getBooks().size());

    // Add new book
    Book book2 = new Book("MyBook2", "Divyakumar", "978 90 274 3964 3", 2024);
    String returnMessage2 = library.addNewBook(book2);
    assertEquals(2, library.getBooks().size());
    assertEquals(book2, library.getBooks().get("978 90 274 3964 3"));
    assertEquals("Book added successfully.", returnMessage2);
  }

  @Test
  public void testBorrowBook() {
    library.addNewBook(book);
    Book borrowedBook = library.borrowBook("978 90 274 3964 2");
    assertFalse(borrowedBook.isAvailable());

    // Borrow unavailable book
    assertThrows(BookNotAvailableException.class, () -> {
      library.borrowBook("978 90 274 3964 2");
    });

    // Borrow a book that is not in the library
    assertThrows(BookNotFoundException.class, () -> {
      library.borrowBook("978 90 274 3964 9");
    });
  }

  @Test
  public void testReturnBorrowedBook() {
    library.addNewBook(book);
    library.borrowBook("978 90 274 3964 2");
    String returnMessage = library.returnBorrowedBook("978 90 274 3964 2");
    assertEquals("Book returned to library successfully.", returnMessage);

    // Return a book that is not borrowed
    assertThrows(BookNotAvailableException.class, () -> {
      library.returnBorrowedBook("978 90 274 3964 8");
    });
  }
}
