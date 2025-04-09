package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EventHandler {
    ArrayList<Event> events = new ArrayList<>();
    EventHandler(ArrayList<Event> events)
    {
        this.events.addAll(events);
    }
    void Randomize() throws Exception{
        try {
            events.get((int) Math.floor(Math.random() * events.size())).Routine();
        }catch(Exception e)
        {
            throw e;
        }
    }
}
