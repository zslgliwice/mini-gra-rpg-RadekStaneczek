package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Event
{
    public Event()
    {

    }
    void Routine() throws Exception
    {
        System.out.println("Napotkałeś " + this.getClass().getName().split("\\.")[1]);
    }
}
class Fight extends Event
{
    Fight(Player player)
    {
        System.out.println("Napotkałeś ");
    }

    @Override
    void Routine() throws  Exception {
        super.Routine();
    }
}
class Shop extends Event
{
    ArrayList<item> available_items = new ArrayList();
    ArrayList<Integer> prices= new ArrayList();
    itemHandler Handler = new itemHandler();
    Scanner sc = new Scanner(System.in);
    Player player;
    Shop(Player player) throws FileNotFoundException {
        super();
        this.player = player;
    }
    @Override
    public void Routine() throws Exception{
        System.out.println("Witaj w sklepie\nRozejrzyj sie, może znajdziesz coś ciekawego.");
        ShowAvItems();
        System.out.println("Chcesz kupić jakiś przedmiot?\n1.Tak\n2.Nie\n3.Nie,chce sprzedać");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("Jaki?(Podaj numer)");
                input = sc.nextInt();
                if(player.getGold() > prices.get(input-1))
                {
                    Buy(input);
                    player.setGold(player.getGold()-prices.remove(input-1));
                }
                else
                {
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
                }catch (Exception e)
                {
                    e.getMessage();
                }
                break;
        }
    }
    void ShowAvItems()
    {
        ArrayList<item> Randomized = new ArrayList<>();
        Randomized.addAll(Handler.getItems());

        available_items.clear();
        prices.clear();

        for(int i = 0; i < 3; i++)
        {
            available_items.add(Randomized.get((int)Math.floor(Math.random() * Randomized.size())));
            prices.add((int)Math.floor(Math.random()*30 + 1));
        }
        for(int i = 0; i < available_items.size(); i++)
        {
            System.out.println(Integer.toString(i + 1) + ".");
            available_items.get(i).WriteInfo();
            System.out.println("\tCena:" + prices.get(i) + " złota");
        }


    }
    void Buy(int item_index)
    {
        player.AddItemToEq(available_items.get(item_index-1));
        player.setGold(player.getGold() - prices.get(item_index-1));
    }
    void Sell(int item_index)
    {
        int given_gold = (int)Math.floor(Math.random() * 30 + 10);
        player.DeleteItemFromEq(item_index-1);
        player.setGold(player.getGold() + given_gold);
        System.out.println("Dostałeś " + Integer.toString(given_gold) + " złota");
    }

}
class Oboz extends Event
{
    Oboz(Player player) {
        super();
    }
    void Routine() throws Exception{
        super.Routine();

    }
}
