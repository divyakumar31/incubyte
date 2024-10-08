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

  @SuppressWarnings("unused")
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

  @SuppressWarnings("unused")
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

    // Future Publication Year
    assertThrows(IllegalArgumentException.class, () -> {
      Book book = new Book("MyBook", "Divyakumar", "978 90 274 3964 4", 2025);
    });
  }

  @Test
  public void testISBNLength() {
    Book book = new Book("t", "a", "123-46-578-9101-2", 2000);

    Book book2 = new Book("t", "a", "123 46 578 1101 2", 2000);

    // ISBN less then length 13
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      Book book1 = new Book("title", "Author", "123 45 678 9", 2000);
    });

    assertEquals("ISBN should be the length of 13.", exception.getMessage());

    assertThrows(IllegalArgumentException.class, () -> {
      Book book1 = new Book("title2", "Author2", "123 45 678 9123 4567", 2000);
    });
  }
}
