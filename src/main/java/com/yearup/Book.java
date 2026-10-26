package com.yearup;
public class Book {
    // These are the properties.
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    // Default Constructor used for scanner
    public Book() {
        this.id = 0;
        this.isbn = "";
        this.title = "";
        this.isCheckedOut = false;
        this.checkedOutTo = "";

    }

    // Here are the getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void checkOut(String name) {
        setCheckedOutTo(name); // We are setting it so that the system will provide the name of the person checking out.
        setCheckedOut(true); // so that the system reflects the checked out state.
    }

    public void checkIn(String name) {
        setCheckedOutTo(""); // This will reset the name to nothing
        setCheckedOut(false); // and change the status of this book to false.

    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn +
                ", title='" + title +
                '}';
    }
}
