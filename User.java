import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap; //to learn deeper
import java.util.Map; //same

public class User {
    private String name;
    private int age;
    private ArrayList<String> borrowedBooks = new ArrayList<>();
    private Map<String, LocalDate> borrowedBooksDueDates = new HashMap<>();

    
    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
        System.out.println("Book borrowed: " + bookTitle + ". Due date: " + dueDate);
    }

    public void returnBook(String bookTitle) {
        if (borrowedBooks.contains(bookTitle)) {
            borrowedBooks.remove(bookTitle);
            borrowedBooksDueDates.remove(bookTitle);
            System.out.println("Successfully returned the book: " + bookTitle);
        } else {
            System.out.println("Book not found in borrowed list: " + bookTitle);
        }
    }

    public void printBorrowedBooks() {
        System.out.println("Borrowed Books: " + borrowedBooks);
    }


    public void checkDueDates() {
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Due Date: " + entry.getValue());
        }
    }
    
    public void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
            LocalDate dueDate = entry.getValue();
            String bookTitle = entry.getKey();
            long daysOverdue = today.isAfter(dueDate) ? today.toEpochDay() - dueDate.toEpochDay() : 0;

            String message = (daysOverdue > 0) 
                ? "Book: " + bookTitle + " is overdue by " + daysOverdue + " days"
                : "Book: " + bookTitle + " is not overdue";
            System.out.println(message);
        }
    }
}