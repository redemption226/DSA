package LLD.EventManagement;

public class Person implements IPerson{
    String firstName;
    String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        return this.firstName + " " + this.lastName;
    }
}
