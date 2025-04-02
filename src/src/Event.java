package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Event
{
    Event(String name)
    {

        System.out.println("Napotkałeś " + name);
    }
}
class Fight extends Event
{
    Fight()
    {
        super("Fight");
    }
}
class Shop extends Event
{
    ArrayList<item> available_items = new ArrayList();
    ArrayList<Integer> prices= new ArrayList();
    itemHandler Handler = new itemHandler();
    public Shop() throws FileNotFoundException {
        super("sklep");
        System.out.println("Witaj w sklepie");
        ShowAvItems();
        System.out.println("Chcesz kupić jakiś przedmiot");
    }
    void ShowAvItems()
    {
        ArrayList<item> Randomized = new ArrayList<>();
        Randomized.addAll(Handler.getItems());

        for(int i = 0; i < 3; i++)
        {
            available_items.add(Randomized.get((int)Math.floor(Math.random() * 3)));
            prices.add((int)Math.floor(Math.random()*40 + 10));
        }
        for(int i = 0; i < available_items.size(); i++)
        {
            available_items.get(i).WriteInfo();
            System.out.println("\tCena:" + prices.get(i) + " złota");
        }


    }
    void Buy(Player player)
    {

    }
    void Sell(Player player)
    {

    }

}
class Oboz extends Event
{
    Oboz()
    {
        super("Oboz");
    }
}
