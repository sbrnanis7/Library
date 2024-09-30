import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                System.out.println("Book Found: " + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the title: " + title);
        }
    }

    public void borrowBook(User user, String title) {
        List<Book> availableBooks = books.stream()
                                         .filter(book -> book.getTitle().equalsIgnoreCase(title) && book.isAvailable())
                                         .collect(Collectors.toList());

        if (!availableBooks.isEmpty()) {
            Book book = availableBooks.get(0);
            book.setAvailable(false);
            user.borrowBook(book.getTitle());
        } else {
            System.out.println("Book is  unavailable.");
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void listAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                book.printBookInfo();
            }
        }
    }

    public void getBorrowedBooksForAllUsers() {
        for (User user : users) {
            System.out.println("User: " + user.getName());
            user.printBorrowedBooks();
        }
    }
}
