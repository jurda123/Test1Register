package register;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.jar.Attributes.Name;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
	/** register.Person array. */
	private Person[] persons;

	/** Number of persons in this register. */
	private int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */
	public ArrayRegister(int size) {
		persons = new Person[size];
		count = 0;
	}

	
	@Override
	public int getCount() {
		return count;
	}

	
	@Override
	public int getSize() {
		return persons.length;
	}

	
	@Override
	public Person getPerson(int index) {
		return persons[index];
	}

	
	@Override
	public void addPerson(Person person) {
		if (isInList(person)) {
			throw new UnsupportedOperationException(
					"name or number is already in the register");
		}
		persons[count] = person;
		count++;
	}

	
	@Override
	public boolean isInList(Person person) {
		for (int i = 0; i < count; i++) {
			if (persons[i].getName().equals(person.getName())) {
				return true;
			} else {
				if (persons[i].getPhoneNumber().equals(person.getPhoneNumber())) {
					return true;
				}
			}
		}

		return false;

	}

	
	@Override
	public Person findPersonByName(String name) {
		for (int i = 0; i < count; i++) {
			if (persons[i].getName().equals(name)) {
				return persons[i];
			}
		}
		System.out.println("no matches found");
		return null;
	}

	
	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
		for (int i = 0; i < count; i++) {
			if (persons[i].getPhoneNumber().equals(phoneNumber)) {
				return persons[i];
			}
		}
		System.out.println("no matches found");
		return null;
	}

	
	@Override
	public void removePerson(Person person) {
		for (int i = 0; i < count; i++) {
			if (persons[i].equals(person)) {
				ArrayList<Person> list = new ArrayList<Person>(
						Arrays.asList(persons));
				list.remove(i);
				persons = list.toArray(persons);

				count--;
			}
		}

	}

	public void sortArray(){
		int rovne;
		for (int i=0; i < count; i++) {
			for (int j=0;j < count;j++) {
				rovne =persons[i].getName().compareToIgnoreCase(persons[j].getName());
			if (rovne<0){
				Person person;
				person = persons[i];
				persons[i] = persons[j];
				persons[j] = person;
			}
					
				
			}
		}
	//	Arrays.sort(persons);
	
		
		
		
	}
	@Override
	public void upgradePerson(Person person, String name, String number) {
		person.setName(name);
		person.setPhoneNumber(number);

	}
}
