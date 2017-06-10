package model;

/**
 * This class provides the Contact constructor to create new contact objects
 *
 * @author Boris Bischoff
 * @date 2017-06-06
 * @version 1.0
 */

import java.util.ArrayList;

public class Contact {

    private String name;
    private long number;
    private String email;
    private ArrayList<Email> emails;
    private String photo;

    /**
     * Constructor Contact
     *
     * @param name
     * @param number
     * @param email
     * @param photo
     */

    public Contact(String name, long number, String email, String photo) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.photo = photo;
        emails = new ArrayList<Email>();
        addEmail(this.email);
    }

    /**
     * get method to get the contact's name of the object
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * get method to get the contact's number of the object
     * @return number
     */
    public long getNumber() {
        return number;
    }

    /**
     * get method to get the contact's email address of the object
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * get method to get the contact's email address of the object
     * @return emails
     */
    public ArrayList<Email> getEmails() {
        return emails;
    }

    /**
     * add method for more email addresses
     */
    public void addEmail(String email) {
        if (Email.checkEmail(email)) {
            emails.add(new Email(email));
        }
    }

    /**
     * get method to get the contact's photo of the object
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * toString method formatting the output of the object's contents
     */
    @Override
    public String toString() {
        return name + "\t" + number;
    }
}