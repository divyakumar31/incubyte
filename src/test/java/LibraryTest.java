import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import com.library.Book;
import com.library.Library;

public class LibraryTest {

  private Book book;

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
}
