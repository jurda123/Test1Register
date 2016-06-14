package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** register.Register of persons. */
    private ArrayRegister register;
    
    /**
     * In JDK 6 use Console class instead.
     * @see readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    };
    
    public ConsoleUI(ArrayRegister register) {
        this.register = register;
    }
    
    public void run() {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT:
                    return;
            }
        }
    }
    
    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();
        
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");
        
        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);
        
        return Option.values()[selection - 1];
    }
    
    //TODO: Implement the method printRegister
    private void printRegister() {
    	register.sortArray();
       for(int i=0;i <register.getCount();i++){
    	   printPerson(register.getPerson(i),i);
    	   
       }
    }
    
    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();
        register.addPerson(new Person(name, phoneNumber));
        register.sortArray();
    }
    
    //TODO: Implement the method updateRegister
    private void updateRegister() {
    	System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
    	System.out.println("1. UPDATE NAME \n2. UPDATE NUMBER \n3. UPDATE NAME AND NUMBER ");
    	int option = Integer.parseInt(readLine());
    	String name=null,number=null;
    	if (option==1){
    		System.out.println("Enter name: ");
            name = readLine();
            register.upgradePerson(person, name, person.getPhoneNumber());
    	}else 
    		if (option==2){
    			System.out.println("Enter number: ");
    	        number = readLine();
    	        register.upgradePerson(person, person.getName(), number);
        	}
    		else if(option==3){
    			System.out.println("Enter name: ");
                name = readLine();
                System.out.println("Enter number: ");
    	        number = readLine();
    	        register.upgradePerson(person, name, number);
    		}
        
        
        
        
        register.sortArray();
    	//  throw new UnsupportedOperationException("Method updateRegister not yet implemented");
    }
    
    //TODO: Implement the method findInRegister
    private void findInRegister() {
    	System.out.println("1. SEARCH BY NAME \n2. SEARCH BY NUMBER ");
        int index = Integer.parseInt(readLine());
    	Person person=null;
    	
    	if(index==1){
    		System.out.println("Enter name or skip: ");
        	String name = readLine();
        	if (!name.equals(null)){
        		person = register.findPersonByName(name);
        	}
    	}
    	else {
    		if(index==2){
    			System.out.println("Enter number or skip: ");
    	    	
    	    	String number = readLine();
    	    	if (!number.equals(null)){
    	    		person = register.findPersonByPhoneNumber(number);
    	    	}
    		}
    	}
    	    	
    	for(int i=0;i <register.getCount();i++){
     	   if (register.getPerson(i).equals(person)){
     		   printPerson(register.getPerson(i),i);
     	   }
    	}
        
    }
    
    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        register.removePerson(person);
        register.sortArray();
    }
    private void printPerson(Person person,int index){
    	System.out.println(index+1 + ". "+ register.getPerson(index).getName() +  "(" + register.getPerson(index).getPhoneNumber() + ")");
    }
}
