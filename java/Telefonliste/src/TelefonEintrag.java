import java.io.IOException;

/**
 * TelefonEintrag / Phone book
 * 
 * This class contains both the main method and the menu for a phone book application.
 * Once being started, there is a object created referring to Telefonliste.java (phone list),
 * that contains all methods used for input prompts, queries and file operations.
 * 
 * @author bsc
 * @version 1.0
 * @date 2017-05-14
 */

public class TelefonEintrag {
	
	/**
	 * Constructor runInstance()
	 *
	 * Creates an object "phoneList" of Telefonliste and shows the menu.
	 * 
	 */
	
	public void runInstance() {
		// Creating object
		Telefonliste phoneList = new Telefonliste();
		// Defining variable
		int selectMenuItem;
		
		// Do-while-loop including switch-case-statement
		do {
			phoneList.readFile();
			System.out.print("Contacts\n"
								+ "[1] New entry\n"
								+ "[2] Delete entry\n"
								+ "[3] Modify entry\n"
								+ "[4] Person lookup\n"
								+ "[5] Number lookup\n"
								+ "[6] Show contacts\n"
								+ "Please enter a number and press RETURN, 0 for Quit: ");
			selectMenuItem = phoneList.getInputForNumber();
			
			switch(selectMenuItem) {
				case 1: 
					System.out.println("New entry");
					phoneList.addEntry();
					break;
				
				case 2:
					System.out.println("Delete entry");
					phoneList.deleteEntry();
					break;
					
				case 3:
					System.out.println("Modify entry");
					phoneList.modifyEntry();
					break;
				case 4:
					System.out.println("Person lookup");
					phoneList.personLookup();
					break;
				case 5:
					System.out.println("Number lookup/Reverse lookup");
					phoneList.numberLookup();
					break;
				case 6:
					System.out.println("Contacts");
					phoneList.getPhoneNumbers();
					break;
				case 0:
					System.out.println("Exiting.");
					break;
				default:
					System.out.println("Please select a function you want to proceed with.");
					break;
			}
	
		} while (selectMenuItem != 0);
	}

	/**
	 * Main method
	 * Creates object of default constructor and calls runInstance()
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		TelefonEintrag phoneBook = new TelefonEintrag();
		phoneBook.runInstance();
	}

}
