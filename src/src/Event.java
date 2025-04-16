package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Event {
    void Routine() throws Exception {
        System.out.println("Napotkałeś " + this.getClass().getName().split("\\.")[1]);
    }
}

class Fight extends Event {
    Player player;
    static Enemy enemy;
    static ArrayList<String> names = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    AttackHandler AtkHandler;

    Fight(Player player) {
        this.player = player;
        names.add("Wilk");
        names.add("Goblin");
        names.add("Drzewiec");
        names.add("Krasnal");
    }

    @Override
    void Routine() throws Exception {
        enemy = new Enemy((int) Math.random() * 15 + 15, (int) Math.random() * 15 + 5, names.get((int) Math.random() * names.size()));
        int input;
        System.out.println("Napotkałeś " + enemy.getName() + "a");
        AtkHandler = new AttackHandler(enemy,player);
        do {
            System.out.println("Co chcesz zrobić?\n1.Zaatakować\n2.Użyć przedmiotu\n3.Uciec");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    AtkHandler.Attack(2);
                    break;
                case 2:
                    player.WriteEq();
                    break;
                case 3:
                    break;
            }
            AtkHandler.Attack(1);
        } while (enemy.getHp() > 0 && player.getHp() > 0);
    }
}
class Shop extends Event {
    ArrayList<item> available_items = new ArrayList<>();
    ArrayList<Integer> prices = new ArrayList<>();
    itemHandler Handler;

    Scanner sc = new Scanner(System.in);
    Player player;

    Shop(Player player) throws FileNotFoundException {
        this.player = player;
        try {
            Handler = new itemHandler();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Routine() throws Exception {
        System.out.println("Witaj w sklepie\nRozejrzyj sie, może znajdziesz coś ciekawego.");
        ShowAvItems();
        System.out.println("Chcesz kupić jakiś przedmiot?\n1.Tak\n2.Nie\n3.Nie,chce sprzedać");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("Jaki?(Podaj numer)");
                input = sc.nextInt();
                if (player.getGold() >= prices.get(input - 1)) {
                    Buy(input);
                } else {
                    throw new Exception("Nie masz wystarczająco złota");
                }
                break;
            case 2:
                break;
            case 3:
                try {
                    player.WriteEq();
                    System.out.println("Co?(Podaj numer)");
                    input = sc.nextInt();
                    Sell(input);
                } catch (Exception e) {
                    e.getMessage();
                }
                break;
        }
    }

    void ShowAvItems() {
        ArrayList<item> Randomized = new ArrayList<>();
        Randomized.addAll(Handler.getItems());

        available_items.clear();
        prices.clear();

        for (int i = 0; i < 3; i++) {
            available_items.add(Randomized.get((int) Math.floor(Math.random() * Randomized.size())));
            prices.add((int) Math.floor(Math.random() * 30 + 1));
        }
        for (int i = 0; i < available_items.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ".");
            available_items.get(i).WriteInfo();
            System.out.println("\tCena:" + prices.get(i) + " złota");
        }


    }

    void Buy(int item_index) {
        player.AddItemToEq(available_items.get(item_index - 1));
        player.setGold(player.getGold() - prices.get(item_index - 1));
    }

    void Sell(int item_index) {
        int given_gold = (int) Math.floor(Math.random() * 30 + 10);
        player.DeleteItemFromEq(item_index - 1);
        player.setGold(player.getGold() + given_gold);
        System.out.println("Dostałeś " + Integer.toString(given_gold) + " złota");
    }

}

class Oboz extends Event {
    static Scanner sc = new Scanner(System.in);
    Player player;

    Oboz(Player player) {
        this.player = player;
    }

    void Routine() throws Exception {
        super.Routine();
        int input;
        boolean exit = false;
        do {
            System.out.println("Chcesz sie uleczyć?\n1.Tak\n2.Nie");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    int randomHp = (int) Math.floor(Math.random() * 20 + 5);
                    player.setHp(player.getHp() + randomHp);
                    if (player.getHp() > player.getMax_hp()) {
                        player.setHp(player.getMax_hp());
                    }
                    exit = true;
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        } while (input < 1 || input > 3 || !exit);

    }
}

