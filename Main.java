public class Main {
    public static void main(String[] args) {
        
        Library library = new Library();

        
        Book book1 = new Book("For One More Day", "Mitch Albom", "11000");
        Book book2 = new Book("Tuesday with Morrie", "Mitch Albom", "11500");
        library.addBook(book1);
        library.addBook(book2);
 
        User user1 = new User("Jessie", 27);
        User user2 = new User("Ayuni", 20);
        library.addUser(user1);
        library.addUser(user2);
        
        library.borrowBook(user1, "For One More Day");
        library.borrowBook(user2, "Tuesday with Morrie");

        System.out.println("\n--- Available Books ---");
        library.listAvailableBooks();

        System.out.println("\n--- Borrowed Books ---");
        library.getBorrowedBooksForAllUsers();

        System.out.println("\n--- Due Dates ---");
        user1.checkDueDates();
        user2.checkDueDates();

        System.out.println("\n--- Overdue Books ---");
        user1.checkOverdueBooks();
        user2.checkOverdueBooks();
    }
}