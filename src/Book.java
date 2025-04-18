public class Book {

    //setting properties for variables
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    //overload constructor

    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";

    }
    //getter method
    public int getId(){
        return id;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public boolean getIsCheckedOut(){
        return isCheckedOut;
    }
    public String CheckedOutTo(){
        return checkedOutTo;
    }
    //setter  method



    //method to checkout
    public void checkOut(String name){
        isCheckedOut = true;
        checkedOutTo = name;
    }
    //method to check in
    public void  checkIn(){
        isCheckedOut = false;
        checkedOutTo = "";
    }
    //methods to display
    public String display(){
        return id + " | "+ isbn + " | "+ title;
    }
    public String displayWithUser(){
        return id + " | " + isbn + " | "+ title + " | Checked out By: " + checkedOutTo;

    }
}
