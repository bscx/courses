package model;
/**
 * This class populates the list with sample entries
 * add provides a method to add new contacts
 *
 * @author Boris Bischoff
 * @date 2017-06-05
 * @version 1.0
 */

import java.util.ArrayList;

public class Contacts {

    private static ArrayList<Contact> contacts = new ArrayList<>();

    public Contacts() {
        contacts.add(new Contact("Marie Curie", 12345, "mariecurie@gmail.com","./resources/marie.jpg"));
        contacts.add(new Contact("Rosa Parks", 23456, "mail@rosaparks.com", "./resources/rosa.jpg"));
        contacts.add(new Contact("Marissa Mayer", 99998, "marissa.mayer@yahoo.com", "./resources/marissa.jpg"));
    }

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static void addToList(String name, long number, String emailAddress, String photo) {
        if (photo.contentEquals("")) {
            photo = "./resources/blank.png";
        }
        contacts.add(new Contact(name, number, emailAddress, photo));
    }

    public static void main (String args[]) {
        Contacts bla = new Contacts();
        System.out.println(contacts);
    }

}