package LLD.EventManagement;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        Person person1 = new Person("Jane", "Smith");
        Person person2 = new Person("John", "Doe");
        Person person3 = new Person("Richard", "Roe");

        EventInfo e1 = new EventInfo("Event1", 2021,2, false);
        EventInfo e2 = new EventInfo("Event2", 2020,2, false);

        List<IEventInfo> ls = new ArrayList<>();
        ls.add(e1);
        ls.add(e2);

        EventManager manager = new EventManager(ls);

        e1.register(person2);
        e2.register(person2);
        e1.register(person3);
        e1.register(person1);
        e2.register(person1);
        e1.attend(person2);
        e1.attend(person3);

        System.out.println(manager.getEventCountByYears());
        System.out.println(manager.getEventRegistrationCountByYears());
        System.out.println(manager.getAttendiesCountByYears());


    }
}
