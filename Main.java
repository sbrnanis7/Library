public class Main {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Add books
        library.addBook(new Book("For One More Day", "Mitch Albom", "11010"));
        library.addBook(new Book("Five People You Met in Heaven", "Mitch Albom", "11900"));
        library.addBook(new Book("Tuesday with Morrie", "Mitch Albom", "11500"));

        // Create users
        User alice = new User("Jessie", 25);
        User bob = new User("Ayuni", 31);
        
        // Add users to the library
        library.addUser(Jessie);
        library.addUser(Ayuni);

        // Borrow books
        library.borrowBook(Jessie, "For One More Day");
        library.borrowBook(Ayuni, "Tuesday with Morrie");

        // Check due dates
        alice.checkDueDates();
        bob.checkDueDates();

        // Simulate overdue check
        alice.checkOverdueBooks();
        bob.checkOverdueBooks();

        // List available books
        System.out.println("\n----------Available Books:----------");
        library.listAvailableBooks();

        // Print borrowed books for all users
        System.out.println("\n----------Borrowed Books:----------");
        library.getBorrowedBooksForAllUsers();
    }
}

