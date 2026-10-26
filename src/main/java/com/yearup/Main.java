package com.yearup;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Book[] inventory = {
                new Book(1, "9780743273565", "The Great Gatsby"),
                new Book(2, "9780061120084", "To Kill a Mockingbird"),
                new Book(3, "9780451524935", "1984"),
                new Book(4, "9780141439518", "Pride and Prejudice"),
                new Book(5, "9780316769488", "The Catcher in the Rye"),
                new Book(6, "9780547928227", "The Hobbit"),
                new Book(7, "9780590353427", "Harry Potter and the Sorcerer's Stone"),
                new Book(8, "9780060850524", "Brave New World"),
                new Book(9, "9780142437247", "Moby-Dick"),
                new Book(10, "9780439023481", "The Hunger Games"),
                new Book(11, "9780307474278", "The Da Vinci Code"),
                new Book(12, "9780618640157", "The Lord of the Rings"),
                new Book(13, "9780062315007", "The Alchemist"),
                new Book(14, "9780385490818", "The Handmaid's Tale"),
                new Book(15, "9781451673319", "Fahrenheit 451"),
                new Book(16, "9780140449136", "Crime and Punishment"),
                new Book(17, "9780743477123", "Hamlet"),
                new Book(18, "9780441172719", "Dune"),
                new Book(19, "9780553293357", "Foundation"),
                new Book(20, "9780345391803", "The Hitchhiker's Guide to the Galaxy")
        };



        Scanner read = new Scanner(System.in);

        int choice = 1; // options for user to sort through. This allows the user to enter numbers and letters

        while (choice != 0) {
            System.out.println("\n=== Welcome! ===");
            System.out.println("What would you like to do?");
            System.out.println("1. View books");
            System.out.println("2. Select a book");
            System.out.println("3. Return a book");
            System.out.println("0. Exit");
            System.out.println("Choose: ");

            if (read.hasNextInt()) { // this is confirming if the input is an integer and within scope.
                choice = read.nextInt();// this one will read the users input
                read.nextLine();
            } else {
                System.out.println("Please enter a valid option");
                read.nextLine(); // it's gobbling up the wrong answer here
                System.out.println("===========================");
                continue; // lets us continue on with the switch case
            }

            switch (choice) {
                case 1:
                    AvailableNow(inventory); // Checking all currently available books through the availablenow method.
                    break;

                case 2:
                    System.out.println("Enter the book number:");

                    if (!read.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        read.nextLine(); // eat me
                        break;
                    }

                    int bookNumber = read.nextInt();

                    read.nextLine(); // this line is being gobbled up.

                    if (bookNumber < 1 || bookNumber > inventory.length) {
                        System.out.println("Please enter a valid book number.");
                        break;
                    }

//                    This is to check if the user input is within the catalog

                    Book selectedBook = inventory[bookNumber - 1]; // gets the book object in the index - 1 and setting it to a new variable..

                    if (!selectedBook.isCheckedOut()) {
                        System.out.println("Enter your name: ");
                        String name = read.nextLine();

                        selectedBook.checkOut(name);

                        System.out.println("This book is now being borrowed by " + name);

                        //System.out.println("Checked out? " + selectedBook.isCheckedOut());
                    } else {
                        System.out.println("This book is being borrowed by " + selectedBook.getCheckedOutTo());
                    }

                    break;

                case 3: // returning a book
                    System.out.println("What is the book number you are returning?");
                    if (!read.hasNextInt()) { // checking to see if this number is acceptable for input
                        System.out.println("Please enter a valid book number.");
                        read.nextLine(); // eating line again
                        break;
                    }

                    int returnBookNumber = read.nextInt(); // the book number that will be returned
                    read.nextLine(); // eat me

                    if (returnBookNumber < 1 || returnBookNumber > inventory.length) {
                        System.out.println("This book number is invalid.");
                        break;

                        }

                        Book returnBook = inventory[returnBookNumber - 1]; // selecting the book to return within the array

                        System.out.println("You are returning " + returnBook.getTitle());

                        if (returnBook.isCheckedOut()) { // this will check if isCheckedOut is true for the book.
                            String borrower = returnBook.getCheckedOutTo();

                            returnBook.checkIn(borrower); // executing the checkIn method.
                            System.out.println("Book returned!");
                        } else {
                            System.out.println("This book is already in our system.");
                    }
                        break;

                case 0:
                    System.out.println("Exiting library now...");
                    break;

                default:
                    System.out.println("This choice is invalid!"); // this will run if the input is not valid.
            }

        }
        System.out.println("Have a nice day!");
        read.close();




    } // this marks the end of the main branch.

    // This
    public static void AvailableNow(Book[] inventory) {

        System.out.println("Available books");
        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() +
                        "\n Title: " + book.getTitle() +
                        "\n ISBN: " + book.getIsbn());
            }


        }
    }
    public static void AlreadyCheckedOut(Book[] inventory) {
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() +
                        "\n Title: " + book.getTitle() +
                        "\n ISBN: " + book.getIsbn());
            }
        }

    }



}




