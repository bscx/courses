import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Telefonliste / phone list
 * 
 * The class to which TelefonEintrag is referring to. It contains all necessary methods.
 * Hint: This file also includes another class called "PhoneEntry". Please see its documentation.
 * 
 * @author bsc
 * @version 1.0
 * @date 2017-05-14
 */

public class Telefonliste {

	private ArrayList<PhoneEntry> phoneList;
	private PhoneEntry p;
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private String file = "phoneList";
	
	/**
	 * Reads the file
	 * 
	 */

	public void readFile() {
		try {
			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			try {
				phoneList = (ArrayList<PhoneEntry>) objectInput.readObject();
				fileInput.close();				
			}
			catch (Exception e) {
				System.err.println("Could not read content.");
			}
		}
		catch (Exception e) {
			System.err.println("File not found, creating new file " + file + "." );
			phoneList = new ArrayList<>();
		}
	}
	
	/**
	 * Writes the file
	 */
	
	public void writeFile() {
		try {
			FileOutputStream fileOutput = new FileOutputStream(file);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			try {
				objectOutput.writeObject(phoneList);
				objectOutput.close();
			}
			catch (Exception e) {
				System.err.println("Could not write content to file.");
			}
		}
		catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Get all phone numbers
	 */
	
	public void getPhoneNumbers() {
		phoneList
			.stream()
			.forEach(System.out::println);
	}
	
	/**
	 * Adds entry to phone list
	 */
	
	public void addEntry() {
		System.out.print("Name: ");
		String entryName = getInputForName();
		System.out.print("Number: ");
		int entryNumber = getInputForNumber();
		
		p = new PhoneEntry(entryName, entryNumber);
		
		try {
			phoneList.add(p);
			writeFile();
			
			System.out.println("Entry " + p.getName() + " has been added.");
		}
		catch (Exception e) {
			System.err.println("Could not write item into array.");
		}
	}
	
	/**
	 * Deletes entry by entering the phone number
	 * 
	 * @throws NoSuchElementException
	 */
	
	public void deleteEntry() throws NoSuchElementException {
		System.out.print("Number: ");
		int entryNumber = getInputForNumber();
		try {
			PhoneEntry toBeDeletedEntry = phoneList
					.stream()
					.filter(n -> n.getNumber() == entryNumber)
					.findFirst()
					.get();
			
			try {
				phoneList.remove(toBeDeletedEntry);
				writeFile();
				System.out.println("Entry " + toBeDeletedEntry.getName() + " has been removed.");
			}
			catch (Exception e) {
				System.out.println("An error occured while removing the contact.");
			}
		}
		catch(Exception e) {
			System.out.println("This number does not exist.");
		}
		
	}
	
	/**
	 * Modifies an entry by entering the phone number
	 * 
	 * @throws NoSuchElementException
	 */
	
	public void modifyEntry() throws NoSuchElementException {
		PhoneEntry toBeModifiedEntry;
		System.out.print("Number: ");
		int entryNumber = getInputForNumber();
		try {
			toBeModifiedEntry = phoneList
					.stream()
					.filter(n -> n.getNumber() == entryNumber)
					.findFirst()
					.get();
			
			try {
				phoneList.remove(toBeModifiedEntry);
				
				System.out.print("Enter new number for " + toBeModifiedEntry.getName() + ": ");
				int newEntryNumber = getInputForNumber();
				
				p = new PhoneEntry(toBeModifiedEntry.getName(), newEntryNumber);
				phoneList.add(p);
				writeFile();
				System.out.println("Entry " + p.getName() + " has been modified.");
			} catch (Exception e) {
				System.out.println("An error has occured while modifying the entry.");
			}
			
		} catch (NoSuchElementException e) {
			System.out.println("This number does not exist.");
		}
		
	}
	
	/**
	 * Looks up the number of a given contact
	 *  
	 */
	
	public void numberLookup() {
		System.out.print("Number: ");
		int entryNumber = getInputForNumber();
		phoneList
			.stream()
			.filter(n -> n.getNumber() == entryNumber)
			.forEach(n -> System.out.println("This is the number of " + n.getName()));
	}
	
	/**
	 * Reverse lookup, looks up the name of a given number
	 * 
	 */

	public void personLookup() {
		System.out.print("Person: ");
		String entryName = getInputForName();
		phoneList
			.stream()
			.filter(n -> n.getName().equals(entryName))
			.forEach(n -> System.out.println(n));
	}
	
	/**
	 * Provides a input prompt for a String
	 * @return bufferedReader.readLine()
	 */
	
	public String getInputForName() {
		while (true) {
			try {
				return bufferedReader.readLine();
			}
			catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
		}
	}
	
	/**
	 * Provides a input prompt for an int
	 * @return Integer.parseInt(bufferedReader.readLine())
	 */
	
	public int getInputForNumber() {
		while (true) {
			try {
				return Integer.parseInt(bufferedReader.readLine());
			}
			catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
		}
	}
}

/**
 * PhoneEntry
 * 
 * This class provides a constructor PhoneEntry for objects that contains a String name and a int number.
 * It furthermore provides two methods getName() and getNumber() and overrides the default toString()
 * method.
 * 
 * It implements Serializable that enables Telefonliste.writeFile() to write an ArrayList including
 * objects of this class into a file on the file system.
 * 
 * @author bsc
 * @version 1.0
 * @date 2017-05-14
 */

class PhoneEntry implements Serializable {
	private static final long serialVersionUID = 6219874518500113866L;
	private String name;
	private int number;
	
	/**
	 * Constructor PhoneEntry
	 * 
	 * @param name
	 * @param number
	 */
	
	public PhoneEntry(String name, int number) {
		this.name = name;
		this.number = number;
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
	public int getNumber() {
		return number;
	}
	
	/**
	 * toString method formatting the output of the object's contents
	 */
    @Override
    public String toString() {
        return name + "\t\t\t" + number;
    }
}
