import java.util.Comparator;
import java.util.Random;

public class ComparatorSort {
    interface Comparator<T> {
        int compare(T first, T second);
    }

    public static void main(String[] args) {

        BookComparator myComparator = new BookComparator();

        Book[] books = new Book[50];
        books[0] = new Book("King", "Cell");
        books[1] = new Book("Orwell", "1964");
        books[2] = new Book("King", "Shining");



        bubbleSort(books, myComparator);

    }

    private static void bubbleSort(Book[] books, BookComparator myComparator) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < books.length - 1; i++) {
                Book first = books[i];
                Book second = books[i + 1];
                if (myComparator.compare(first, second) > 0) {
                    Book x = books[i];
                    books[i] = books[i + 1];
                    books[i + 1] = x;
                    sorted = false;
                }
            }
        }
    }


    static class Book {
        private String author;
        private String name;
        private int id;

        Book(String author, String name) {
            this.author = author;
            this.name = name;
            this.id = new Random().nextInt(100);
        }

        public String getAuthor() {
            return author;
        }

        public String getName() {
            return name;
        }

        public Integer getId() {
            return id;
        }

        public String toString() {
            return "[" + id + "]" + author + ". '" + name + "'";
        }
    }

    static class BookComparator implements Comparator<Book> {

        @Override
        public int compare(Book first, Book second) {
            return first.getId().compareTo(second.getId());
        }
    }

}
