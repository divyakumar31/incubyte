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

  @Test
  public void testNullBook() {
    // Null Book Title
    assertThrows(NullPointerException.class, () -> {
      Book book = new Book(null, "divyakumar", "978 90 274 3964 3", 2024);
    });

    // Null Book Author
    assertThrows(NullPointerException.class, () -> {
      Book book = new Book("MyBook", null, "978 90 274 3964 4", 2024);
    });

    // Null Book ISBN
    assertThrows(NullPointerException.class, () -> {
      Book book = new Book("MyBook", "Divyakumar", null, 2024);
    });
  }

  @Test
  public void testEmptyBook() {
    // Empty Book Title
    assertThrows(IllegalArgumentException.class, () -> {
      Book book = new Book("", "divyakumar", "978 90 274 3964 3", 2024);
    });

    // Empty Book Author
    assertThrows(IllegalArgumentException.class, () -> {
      Book book = new Book("MyBook", "", "978 90 274 3964 4", 2024);
    });

    // Empty Book ISBN
    assertThrows(IllegalArgumentException.class, () -> {
      Book book = new Book("MyBook", "Divyakumar", "", 2024);
    });

    // Negative Publication Year
    assertThrows(IllegalArgumentException.class, () -> {
      Book book = new Book("MyBook", "Divyakumar", "978 90 274 3964 4", -1900);
    });
  }
}
