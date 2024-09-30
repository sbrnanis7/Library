import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private ArrayList<String> borrowedBooks;
    private Map<String, LocalDate> borrowedBooksDueDates;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooksDueDates = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void borrowBook(String bookTitle) {
        borrowedBooks.add(bookTitle);
        LocalDate dueDate = LocalDate.now().plusDays(14);
        borrowedBooksDueDates.put(bookTitle, dueDate);
        System.out.println("Book '" + bookTitle + "' borrowed. Due date: " + dueDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
    }

    public void returnBook(String bookTitle) {
        if (borrowedBooks.contains(bookTitle)) {
            borrowedBooks.remove(bookTitle);
            borrowedBooksDueDates.remove(bookTitle);
            System.out.println("Book '" + bookTitle + "' has been returned.");
        } else {
            System.out.println("Book '" + bookTitle + "' is not found in the borrowed list.");
        }
    }

    public void printBorrowedBooks() {
        System.out.println("Borrowed Books: " + borrowedBooks);
    }

    public void checkDueDates() {
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Due Date: " + entry.getValue().format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        }
    }

    public void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
            String bookTitle = entry.getKey();
            LocalDate dueDate = entry.getValue();
            String result = today.isAfter(dueDate) ? "Overdue by " + (today.toEpochDay() - dueDate.toEpochDay()) + " days" : "Not overdue";
            System.out.println("Book: " + bookTitle + ", " + result);
        }
    }
}


