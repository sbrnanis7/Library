import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                book.printBookInfo();
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void borrowBook(User user, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                user.borrowBook(title);
                System.out.println("Book borrowed successfully: " + title);
                return;
            }
        }
        System.out.println("Book not available or not found: " + title);
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
            System.out.println("User: " + user.getName() + ", Borrowed books:");
            user.printBorrowedBooks();
        }
    }
}