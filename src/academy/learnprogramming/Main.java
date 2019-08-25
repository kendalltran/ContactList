package academy.learnprogramming;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
	    boolean quit = false;
	    int choice = 0;
	    printInstructions();
	    while(!quit) {
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // clear input buffer
            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }

    public static void printInstructions() {
        System.out.println("Instructions: " +
                "\n\t 0 - Print Instructions" +
                "\n\t 1 - Print Contact List" +
                "\n\t 2 - Add Contact" +
                "\n\t 3 - Update Contact" +
                "\n\t 4 - Remove Contact" +
                "\n\t 5 - Find Contact" +
                "\n\t 6 - Quit");
    }

    public static void printContactList() {
        mobilePhone.printContactList();
    }

    public static void addContact() {
        System.out.print("Enter Contact Name: ");
        String name = input.nextLine();
        input.nextLine(); // clear input buffer
        System.out.print("Enter Phone Number: ");
        String phoneNumber = input.nextLine();
        input.nextLine(); // clear input buffer
        mobilePhone.addContact(name, phoneNumber);
    }

    public static void updateContact() {
        System.out.print("Enter Contact Name to update: ");
        String searchContact = input.nextLine();
        Contacts contactResult = mobilePhone.findContact(searchContact);
        if (contactResult != null) {
            mobilePhone.printContact(contactResult);
            System.out.print("Above Contact Found.  Update Contact?  Enter Y or N: ");
            String confirmUpdate = input.nextLine().toLowerCase();
            if (confirmUpdate.equals("y")) {
                System.out.print("Enter New Contact Name: ");
                String newName = input.nextLine();
                System.out.print("Enter New Phone Number: ");
                String newPhoneNumber = input.nextLine();
                mobilePhone.updateContact(contactResult, newName, newPhoneNumber);
                System.out.println("Contact Updated.");
            } else {
                System.out.println("Update cancelled");
            }
        } else {
            System.out.println("Could not find contact.");
        }
    }

    public static void removeContact() {
        System.out.print("Enter Contact Name to remove: ");
        String searchContact = input.nextLine();
        Contacts contactResult = mobilePhone.findContact(searchContact);
        if (contactResult != null) {
            mobilePhone.printContact(contactResult);
            System.out.print("Above Contact Found.  Delete Contact?  Enter Y or N: ");
            String confirmRemoval = input.nextLine().toLowerCase();
            if (confirmRemoval.equals("y")) {
                mobilePhone.removeContact(contactResult);
                System.out.println("Contact Removed.");
            } else {
                System.out.println("Removal cancelled");
            }
        } else {
            System.out.println("Could not find contact.");
        }
    }
    public static void findContact() {
        System.out.print("Enter Contact Name to search for: ");
        String searchContact = input.nextLine();
        Contacts contactResult = mobilePhone.findContact(searchContact);
        if (contactResult != null) {
            mobilePhone.printContact(contactResult);
        } else {
            System.out.println("Could not find contact.");
        }
    }

}

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.