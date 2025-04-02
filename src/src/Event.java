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

}
class Shop extends Event
{
    ArrayList<item> avaiable_items = new ArrayList();
    itemHandler Handler = new itemHandler();
    public Shop() throws FileNotFoundException {
        super();
        System.out.println("Witaj w sklepie");
        ShowAvItems();
    }
    void ShowAvItems()
    {
        ArrayList<item> Randomized = new ArrayList<>();
        Randomized.addAll(Handler.getItems());

        for(int i = 0; i < 3; i++)
        {
            avaiable_items.add(Randomized.get((int)Math.floor(Math.random() * 3)));
        }
        for(item i : avaiable_items)
        {
            i.WriteInfo();
        }
    }
    void Buy()
    {

    }
    void Sell()
    {

    }

}
class Oboz extends Event
{

}
