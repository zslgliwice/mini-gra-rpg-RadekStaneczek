package src;

import java.util.ArrayList;


public class EventHandler {
    ArrayList<Event> events = new ArrayList<>();

    EventHandler(ArrayList<Event> events) {
        this.events.addAll(events);
    }

    void Randomize() throws Exception {
        events.get((int) Math.floor(Math.random() * events.size())).Routine();
    }
}
