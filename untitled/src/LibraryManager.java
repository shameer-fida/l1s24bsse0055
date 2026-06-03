import java.util.TreeSet;

public class LibraryManager {

    private TreeSet<String> books;

    public LibraryManager() {
        books = new TreeSet<>();
    }

    public void addBook(String title) {
        if (books.add(title)) {
            System.out.println("Book added: " + title);
        } else {
            System.out.println("Book already exists: " + title);
        }
    }

    public void removeBook(String title) {
        if (books.remove(title)) {
            System.out.println("Book removed: " + title);
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    public boolean isBookAvailable(String title) {
        return books.contains(title);
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (String book : books) {
            System.out.println(book);
        }
    }

    public void findBooksByStartingLetter(char letter) {
        boolean found = false;

        for (String book : books) {
            if (!book.isEmpty() &&
                    Character.toUpperCase(book.charAt(0)) ==
                            Character.toUpperCase(letter)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }

    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        library.addBook("Java Programming");
        library.addBook("Data Structures");
        library.addBook("Algorithms");
        library.addBook("Computer Networks");
        library.addBook("Java Programming");

        library.displayAllBooks();

        System.out.println(library.isBookAvailable("Algorithms"));
        System.out.println(library.isBookAvailable("Python Basics"));

        library.findBooksByStartingLetter('A');

        library.removeBook("Computer Networks");

        library.displayAllBooks();
    }
}