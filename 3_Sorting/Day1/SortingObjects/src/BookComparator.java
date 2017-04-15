import java.util.*;

public class BookComparator {
    public static Comparator<Book> Title = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            return b1.getTitle().compareToIgnoreCase(b2.getTitle());
        }
    };
}
