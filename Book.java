public class Book {

    private String title;
    private String author;
    private int quantity;

    //Constructor 
    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    //getter() methods is used for access the private data
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getQuantity() { return quantity; }
}