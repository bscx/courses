package model;

/**
 * This class provides checking and validating for email addresses
 * @author Boris Bischoff
 * @date 2017-06-06
 * @version 1.0
 */

public class Email {
    private String email;

    /**
     * Constructor
     * @param email
     */

    public Email (String email) {
        if (checkEmail(email)) {
            this.email = email;
        }
    }

    /**
     * returns the email address
     * @return email
     */

    public String getEmail(){
        return email;
    }

    /**
     * provides a possibility to check and validate the format of an email address
     *
     * @param email
     * @return true if email address matches regexp pattern
     */

    public static boolean checkEmail (String email) {
        String regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (email.matches(regexp)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString(){
        return email;
    }
}