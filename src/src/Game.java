package src;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;

public class Game {
    static Player player = new Player();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Event> events = new ArrayList<>();
    static ArrayList<Integer> probabilities = new ArrayList<>();
    static EventHandler eventHandler;
    static int difficulty;

    public static void Play() throws FileNotFoundException {
        SetupEventsAndProbabilities();

        System.out.println("Witaj w tajemniczym lesie");
        do{
            System.out.println("\033[H\033[2J");
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
                    player.Equipment();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.equals("3")) {
                try {
                    SavePlayer();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
    public static void SetupEventsAndProbabilities() throws FileNotFoundException {
        events.addAll(List.of(
                new Shop(player),
                new Oboz(player),
                new Fight(player),
                new Skarb(player),
                new Ucieczka()));
        probabilities.addAll(List.of(25, 20, 25, 20, 10));

        eventHandler = new EventHandler(events,probabilities);
    }
    public static void SetDifficulty(int Difficulty) {
        difficulty = Difficulty;
    }
    public static void SavePlayer() throws IOException {
        FileWriter playerFile = new FileWriter("Saves/Save.json");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(player);
        playerFile.write(json);
        playerFile.close();
    }
    public static void LoadPlayer() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("Saves/Save.json");
        player = mapper.readValue(file, Player.class);
    }
}
