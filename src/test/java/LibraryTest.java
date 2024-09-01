import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import com.library.Book;
import com.library.Library;

public class LibraryTest {

  private Book book;
  private Library library;

  @Before
  public void setup() {
    book = new Book("MyBook", "DP", "978 90 274 3964 2", 2024);
  }

  @Test
  public void testLibrary() {
    Library library = new Library();
    assertEquals(0, library.getBooks().size());

    Library library2 = new Library(book);
    assertEquals(1, library2.getBooks().size());
    assertEquals(book, library2.getBooks().get("978 90 274 3964 2"));
  }

  @Before
  public void setupLibrary() {
    library = new Library();
    book = new Book("MyNewBook", "DIVYAKUMAR", "978 90 274 3964 1", 2023);
  }

  @Test
  public void testAddNewBook() {
    String returnMessage = library.addNewBook(book);
    assertEquals(1, library.getBooks().size());
    assertEquals(book, library.getBooks().get("978 90 274 3964 1"));
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
  }
}
