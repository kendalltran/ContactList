package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private ArrayList<Contacts> contactList = new ArrayList<Contacts>();

    public Contacts makeContact(String name, String phoneNumber) {
        return new Contacts(name, phoneNumber);
    }

    public void addContact(String name, String number) {
        Contacts contact = new Contacts(name, number);
        contactList.add(contact);
    }

    public void printContactList(){
        System.out.println("You have " + contactList.size() + " contacts.");
        for (int i = 0; i <= contactList.size() - 1; i++) {
            System.out.println("Contact #" + (i + 1) + ": " + contactList.get(i).getName() + ", " + contactList.get(i).getPhoneNumber());
        }
    }

    public void printContact(Contacts contact) {
        System.out.println("Contact Name: " + contact.getName() + "\nContact Number: " + contact.getPhoneNumber());
    }

    public Contacts findContact(String searchContact){
        for(int i = 0; i <= contactList.size() - 1; i++) {
            if (contactList.get(i).getName().contains(searchContact)) {
                return contactList.get(i);
            }
        }
        return null;
    }

    public void removeContact(Contacts contact) {
        contactList.remove(contact);
    }

    public void updateContact(Contacts contact, String name, String phoneNumber) {
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
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