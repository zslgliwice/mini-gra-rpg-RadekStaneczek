package src;

import java.util.ArrayList;


public class EventHandler {
    ArrayList<Event> events = new ArrayList<>();
    ArrayList<Integer> probabilities = new ArrayList<>();
    EventHandler(ArrayList<Event> events, ArrayList<Integer> probabilities) {
        this.events.addAll(events);
        this.probabilities.addAll(probabilities);
    }

    void Randomize() throws Exception {
        int chance = (int)(Math.random()*100);
        System.out.println(chance);
        int cumulative = 0;
        for (int i = 0; i < probabilities.size(); i++) {
            cumulative += probabilities.get(i);
            if (chance < cumulative) {
                events.get(i).Routine();
                return;
            }

        }
    }
}
