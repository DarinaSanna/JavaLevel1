import java.util.*;

public class ComparatorSort {
    interface Comparator<T> {
        int compare(T first, T second);
    }

    public static void main(String[] args) {

        BookComparator myComparator = new BookComparator();

        ArrayList<Book> books= new ArrayList<>();
        books.add(new Book("King", "Cell"));
        books.add(new Book("Orwell", "1964"));
        books.add(new Book("King", "Shining"));

        bubbleSort(books, myComparator);

        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }

    }

    private static void bubbleSort(ArrayList<Book> books, BookComparator myComparator) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < books.size() - 1; i++) {
                Book first = books.get(i);
                Book second = books.get(i+1);
                if (myComparator.compare(first, second) > 0) {
                    Book x = books.get(0);
                    books.set(i, books.get(i+1));
                    books.set((i + 1), x);
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
            return "[" + id + "] " + author + ". '" + name + "'";
        }
    }

    static class BookComparator implements Comparator<Book> {

        @Override
        public int compare(Book first, Book second) {
            return first.getId().compareTo(second.getId());
        }
    }

}
