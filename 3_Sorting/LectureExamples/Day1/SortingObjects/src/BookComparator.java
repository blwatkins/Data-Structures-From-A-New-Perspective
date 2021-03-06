import java.util.Comparator;

public class BookComparator {

    public static Comparator<Book> Title = new Comparator<Book>() {

        public int compare(Book b1, Book b2) {
            return b1.getTitle().compareToIgnoreCase(b2.getTitle());
        }

    };

    public static Comparator<Book> Year = new Comparator<Book>() {

        public int compare(Book b1, Book b2) {
            return Integer.compare(b1.getYear(), b2.getYear());
        }

    };

    public static Comparator<Book> Author = new Comparator<Book>() {

        public int compare(Book b1, Book b2) {
            return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
        }

    };

    public static Comparator<Book> Size = new Comparator<Book>() {

        public int compare(Book b1, Book b2) {
            return Integer.compare(b1.getSize(), b2.getSize());
        }

    };

}
