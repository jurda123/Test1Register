package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ArrayRegister register = new ArrayRegister(20);

        register.addPerson(new Person("Janko", "123456"));
        register.addPerson(new Person("Ferko", "456789"));
        register.addPerson(new Person("Jurko", "654321"));
        register.addPerson(new Person("Jozko", "987654"));

        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
