package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class itemHandler {
    ArrayList<item> Items = new ArrayList<item>();
    File[]Files = {new File("Items/weapons.txt"),new File("Items/items.txt")};

    public itemHandler() throws FileNotFoundException {
        for (File file : Files)
        {
            Scanner skaner = new Scanner(file);
            if(file.getName().equals("weapons.txt"))
            {
                while (skaner.hasNextLine())
                {
                    String data = skaner.nextLine();
                    String Name = data.split(";")[0];
                    String Desc = data.split(";")[1];
                    int dmg = Integer.valueOf(data.split(";")[2]);
                    Items.add(new weapon(Name,Desc,dmg));
                }
            }
            else
            {
                while (skaner.hasNextLine());
                {
                    String data = skaner.nextLine();
                    String Name = data.split(";")[0];
                    String Desc = data.split(";")[1];
                    int hp = Integer.valueOf(data.split(";")[2]);
                    Items.add(new usable(Name,Desc,hp));
                }
            }
        }

    }
    public ArrayList<item> getItems()
    {
        return Items;
    }
}
