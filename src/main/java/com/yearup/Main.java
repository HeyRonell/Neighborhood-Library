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
            System.out.println("Welcome!");
            System.out.println("What would you like to do?");
            System.out.println("1. View books");
            System.out.println("2. Select a book");
            System.out.println("0. Exit");
            System.out.println("Choose: ");

            if (read.hasNextInt()) { // this is confirming if the input is within the scope.
                choice = read.nextInt(); // this one will read the users input
            } else {
                System.out.println("Please enter a valid option");
                read.nextLine(); // it's gobbling up the wrong answer here
                continue; // lets us continue on with the switch case
            }

            switch (choice) {
                case 1:
                    System.out.println("Available books");
                    //showing the available books
                    for (int count = 0; count < inventory.length; count++) {
                        System.out.println((count + 1) + ". " + inventory[count]);
                    }
                    break;

                case 2:
                    System.out.println("Enter the book number:");
                    int bookNumber = read.nextInt();

                    if (bookNumber >= 1 && bookNumber <= inventory.length) {
                        System.out.println("Selected: " + inventory[bookNumber - 1]);
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting library now...");
                    break;

                default:
                    System.out.println("This choice is invalid!");
            }

        }
        System.out.println("Have a nice day!");
        read.close();

       // public void whatsAvailableNow (Book[],inventory.length, Scanner read){

        //}


    }
}


