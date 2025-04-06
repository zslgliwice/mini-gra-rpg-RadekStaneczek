package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EventHandler {
    ArrayList<Event> events = new ArrayList<>();
    static File file = new File("events.txt");
    void Randomize()
    {
        events.get((int)Math.floor(Math.random() * events.size())).Routine();
    }
}
