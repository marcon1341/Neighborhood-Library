import java.util.Scanner; // Scanner to read user input

public class LibraryApp {

    // array to hold 20 Book objects
    static Book[] books = new Book[20]; // we use static to lets the methods use this one array

    public static void main(String[] args) {
        booksList(); // StFill the array with 20 books
        showMenu();  //Show the menu
    }

    // This method creates 20 sample books and puts them into the array
    public static void booksList() {
        books[0] = new Book(1, "ISBN-2001", "The Secret Garden");
        books[1] = new Book(2, "ISBN-2002", "Alice in Wonderland");
        books[2] = new Book(3, "ISBN-2003", "The Little Prince");
        books[3] = new Book(4, "ISBN-2004", "Charlie and the Chocolate Factory");
        books[4] = new Book(5, "ISBN-2005", "Matilda");
        books[5] = new Book(6, "ISBN-2006", "The Lion, the Witch and the Wardrobe");
        books[6] = new Book(7, "ISBN-2007", "Anne of Green Gables");
        books[7] = new Book(8, "ISBN-2008", "Treasure Island");
        books[8] = new Book(9, "ISBN-2009", "Peter Pan");
        books[9] = new Book(10, "ISBN-2010", "The Wind in the Willows");
    }

    // This shows the main menu to the user
    public static void showMenu() {
        Scanner s = new Scanner(System.in); // Scanner reads input from keyboard

        while (true) { // Loop until the user chooses to exit
            System.out.println("Neighborhood Library");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int option = s.nextInt(); // Read user's input
            s.nextLine(); // newline

            // Use switch to run different code
            switch (option) {
                case 1:
                    showAvailableBooks(s); // Option 1: See books you can borrow
                    break;
                case 2:
                    showCheckedOutBooks(s); // Option 2: See and return borrowed books
                    break;
                case 3:
                    System.out.println("BYE BYE!!!"); // Exit message
                    return; // End the program
                default:
                    System.out.println("Invalid Option Try Again"); // if Wrong number typed this message pops
            }
        }
    }

    // To checked books that are not checked out
    public static void showAvailableBooks(Scanner s) {
        System.out.println("\nAvailable Books");

        for (Book book : books) { // Go through all books

            if (book != null && !book.getIsCheckedOut()) {// Show only books that are NOT checked out
                System.out.println(book.display()); // Print ID, ISBN, and title by referring Book class
            }
        }

        // Ask user if they want to check one out
        System.out.print("Enter Book ID To Check Out Or 0 To Go Back: ");
        int id = s.nextInt();
        s.nextLine(); // newline

        if (id == 0) return; // If 0, go back to main menu

        // Find the book they want
        Book selected = findBookById(id);

        // Check  it hasn't been checked out yet
        if (selected != null && !selected.getIsCheckedOut()) {
            System.out.print("Please Enter Your Name: ");
            String name = s.nextLine(); // Read the user's name

            selected.checkOut(name); // Mark the book as checked out
            System.out.println("Book Checked Out!");
        } else {
            System.out.println("Invalid ID or Book Already Checked Out");
        }
    }

    // This shows books that are already checked out
    public static void showCheckedOutBooks(Scanner s) {
        System.out.println("Checked Out Books:");

        // Go through all books
        for (Book book : books) {
            // Show only books that ARE checked out
            if (book != null && book.getIsCheckedOut()) {
                System.out.println(book.displayWithUser()); // Print book + who borrowed it
            }
        }

        // Ask user if they want to check in or go back
        System.out.print("Enter C to Check In a Book or X to Go Back: ");
        String input = s.nextLine(); // Read their choice

        if (input.equalsIgnoreCase("C")) {
            // If user types C, let them check in a book
            System.out.print("Enter The Book ID To Check In: ");
            int id = s.nextInt();
            s.nextLine(); //newline

            Book selected = findBookById(id); // Find the book by its ID

            if (selected != null && selected.getIsCheckedOut()) {
                selected.checkIn(); // Mark book as returned
                System.out.println("Book Checked In!");
            } else {
                System.out.println("Invalid ID or Book Not Checked Out");
            }
        } else if (input.equalsIgnoreCase("X")) {
            // If user types X, return to menu
            return;
        } else {
            // if User typed something else
            System.out.println("Invalid Option. Please Enter C or X.");
        }
    }

    // This method looks for a book with a matching ID
    public static Book findBookById(int id) {
        for (Book book : books) {
            if (book != null && book.getId() == id) {
                return book; // Found the book
            }
        }
        return null; // when No match found
    }
}
