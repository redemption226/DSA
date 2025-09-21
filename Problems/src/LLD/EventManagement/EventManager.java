package LLD.EventManagement;

import java.util.*;

public class EventManager implements IEventManager{

    List<IEventInfo> events = new ArrayList<>();

    EventManager(List<IEventInfo> events) {
        this.events = events;
    }

    void addEvent(IEventInfo eventInfo) {
        for (IEventInfo event : events) {
            if (event.equals(eventInfo))
                return;
        }
        events.add(eventInfo);
    }

    void register(String eventName, Person person) {
        for (IEventInfo eventInfo : events) {
            if (eventInfo.equals(eventName))
                eventInfo.register(person);
        }
    }

    void attend(String eventName, IPerson person) {
        for (IEventInfo eventInfo : events) {
            if (eventInfo.getEventName().equals(eventName)) {
                for (IPerson registeredPerson : eventInfo.getRegistration())
                    if (registeredPerson.equals(person))
                        eventInfo.attend(person);
            }

        }
    }

    List<String> getEventCountByYears() {
        SortedMap<Integer, Integer> eventByYearMap = new TreeMap<>();

        List<String> eventCountByYears = new ArrayList<>();

        for (IEventInfo event : events) {
            eventByYearMap.putIfAbsent(event.getEventDate(), eventByYearMap.getOrDefault(event.getEventDate(), 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : eventByYearMap.entrySet()) {
            eventCountByYears.add(entry.getKey() + " - " + entry.getValue());
        }


        return eventCountByYears;

    }

    List<String> getEventRegistrationCountByYears() {
        SortedMap<Integer, Integer> eventByYearMap = new TreeMap<>();

        List<String> eventRegistrationCountByYears = new ArrayList<>();

        for (IEventInfo event : events) {
            int registrations = event.getRegistration().size();
            eventByYearMap.putIfAbsent(event.getEventDate(), eventByYearMap.getOrDefault(event.getEventDate(), 0) + registrations);
        }

        for (Map.Entry<Integer, Integer> entry : eventByYearMap.entrySet()) {
            eventRegistrationCountByYears.add(entry.getKey() + " - " + entry.getValue());
        }

        return eventRegistrationCountByYears;
    }

    List<String> getAttendiesCountByYears() {
        SortedMap<Integer, Integer> eventByYearMap = new TreeMap<>();

        List<String> eventRegistrationCountByYears = new ArrayList<>();

        for (IEventInfo event : events) {
            int attendies = event.getAttendees().size();
            eventByYearMap.putIfAbsent(event.getEventDate(), eventByYearMap.getOrDefault(event.getEventDate(), 0) + attendies);
        }

        for (Map.Entry<Integer, Integer> entry : eventByYearMap.entrySet()) {
            eventRegistrationCountByYears.add(entry.getKey() + " - " + entry.getValue());
        }

        return eventRegistrationCountByYears;

    }

}
