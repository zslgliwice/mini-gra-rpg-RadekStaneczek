package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    static Player player = new Player();
    static boolean escaped = false;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Event> events = new ArrayList<>();

    static EventHandler eventHandler;

    public static void Play() throws FileNotFoundException {
        events = new ArrayList<>();
        ArrayList<Integer> probabilities = new ArrayList<>();
        try {
            events.addAll(List.of(
                    new Shop(player),
                    new Oboz(player),
                    new Fight(player)));
                    new Oboz(player);
            probabilities.addAll(List.of(20, 30, 40, 10));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        eventHandler = new EventHandler(events,probabilities);
        System.out.println("Witaj w tajemniczym lesie");
        do{
            player.checkLvlUp();
            WriteInfo();
            String input = sc.nextLine();
            if (input.equals("1")) {
                try {
                    eventHandler.Randomize();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.equals("2")) {
                try {
                    player.WriteEq();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Nie ma takiej opcji");
            }
        }
        while (player.getHp() > 0);
    }

    public static void WriteInfo() {
        System.out.println("Twoje statystyki: " + player.getStats());
        System.out.println("Co chcesz zrobić?");
        System.out.println("1.Eksplorować dalej");
        System.out.println("2.Sprawdzić ekwipunek");
        System.out.println("3.Zakończyć grę");
    }

}
