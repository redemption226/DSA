package LLD.EventManagement;

import java.util.List;

public interface IEventInfo {
    List<IPerson> getRegistration();
    List<IPerson> getAttendees();

     void register(IPerson person);
     void attend(IPerson person);
    String getEventName();
    int getEventDate();
    int getCapacity();
    boolean isCanceled();
}
