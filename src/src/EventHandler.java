package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EventHandler {
    ArrayList<Event> events = new ArrayList<>();
    static File file = new File("events.txt");
    EventHandler() throws FileNotFoundException {
        Scanner skaner = new Scanner(file);
        while (skaner.hasNextLine()) {
            String className = skaner.nextLine().trim(); // Read class name from file

            try {
                Class<?> cls = Class.forName("src." + className);  // Load class dynamically
                Object obj = cls.getDeclaredConstructor().newInstance(); // Create instance

                // Store as an object so you can cast later
                events.add(obj);

                System.out.println("Loaded instance of: " + cls.getName());
            } catch (Exception e) {
                System.out.println("Error loading class: " + className);
                e.printStackTrace();
            }
        }
        skaner.close();
    }
    void Randomize()
    {
        events.get((int)Math.floor(Math.random() * events.size())).Routine();
    }
}
