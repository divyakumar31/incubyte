import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import com.library.Book;

public class BookTest {
  @Test
  public void testBook() {
    Book book = new Book("title", "author", "978 90 274 3964 2", 2024);
    assertEquals("title", book.getTitle());
    assertEquals("author", book.getAuthor());
    assertEquals("978 90 274 3964 2", book.getIsbn());
    assertTrue(2024 == book.getPublicationYear());
    assertTrue(book.isAvailable());
  }
}
