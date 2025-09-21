package LLD.EventManagement;

import java.util.ArrayList;
import java.util.List;

public class EventInfo implements IEventInfo{
    public String eventName;
    public int eventDate;
    public int capacity;
    public boolean isCancelled;
    public List<IPerson> registration = new ArrayList<>();
    public List<IPerson> attendees = new ArrayList<>();

    EventInfo(String eventName, int eventDate, int capacity, boolean isCancelled) {
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.capacity = capacity;
        this.isCancelled = isCancelled;
    }

    @Override
    public void register(IPerson person) {
        if (!isCancelled && registration.size() < capacity) {
            for (IPerson registeredPerson : registration) {
                if (registeredPerson.equals(person)) {
                    return;
                }
            }
            registration.add(person);
        }
    }

    @Override
    public void attend(IPerson person) {
        if (!isCancelled) {
            for (IPerson registeredPerson : registration) {
                if (registeredPerson.equals(person)) {
                    for (IPerson attendingPerson : attendees) {
                        if (person.equals(attendingPerson))
                            return;
                    }
                }
            }
            attendees.add(person);
        }
    }

    @Override
    public String getEventName() {
        return this.eventName;
    }

    @Override
    public int getEventDate() {
        return this.eventDate;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isCanceled() {
        return isCancelled;
    }

    @Override
    public List<IPerson> getRegistration() {
        return registration;
    }

    @Override
    public List<IPerson> getAttendees() {
        return attendees;
    }

}
