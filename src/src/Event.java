package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Event
{
    public Event()
    {

    }
    void Routine()
    {

    }
}
class Fight extends Event
{
    Fight()
    {
        super();
    }

    @Override
    void Routine() {
        super.Routine();
    }
}
class Shop extends Event
{
    ArrayList<item> available_items = new ArrayList();
    ArrayList<Integer> prices= new ArrayList();
    itemHandler Handler = new itemHandler();

    Shop() throws FileNotFoundException {
        super();
    }

    public void Routine() {

        System.out.println("Witaj w sklepie");
        ShowAvItems();
        System.out.println("Chcesz kupić jakiś przedmiot?\n1.Tak\n2.Nie");
    }
    void ShowAvItems()
    {
        ArrayList<item> Randomized = new ArrayList<>();
        Randomized.addAll(Handler.getItems());

        available_items.clear();
        prices.clear();

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
        super();
    }

    @Override
    void Routine() {
        super.Routine();
    }
}
