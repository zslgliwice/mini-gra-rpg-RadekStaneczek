package src;

import java.util.ArrayList;
import java.util.Scanner;


public class Player {
    int hp = 100;
    int gold = 10;

    int base_dmg = 5;
    int dmg = base_dmg;

    int exp = 0;
    int lvl = 1;

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<item> equipment = new ArrayList<>();

    public int getHp() {
        return hp;
    }

    void AddItemToEq(item Item)
    {
        equipment.add(Item);
        System.out.print("Dodano do ekwipunku:\n");
        Item.WriteInfo();
    }

    void WriteEq() throws Exception
    {
        if(!equipment.isEmpty()) {
            for (int i = 0; i < equipment.size(); i++) {
                System.out.println();
                System.out.print(Integer.toString(i+1) + ".");
                equipment.get(i).WriteInfo();
            }
            System.out.print("Czy chcesz wykorzystać item?\n1.Tak\n2.Nie\n\n");
            String in = scanner.nextLine();
            switch (in) {
                case "1":
                    System.out.print("Wybierz(podaj numer):");
                    in = scanner.nextLine();
                    Equip(equipment.get(Integer.parseInt(in) - 1));
                    break;
                case "2":
                    break;
                default:
                    throw new Exception("Nie ma takiej opcji");

            }
        }
        else {
            throw new Exception("Masz pusty ekwipunek");
        }
    }

    void Equip(Object Item) {
        if (Item instanceof weapon) {
            dmg = base_dmg + ((weapon) Item).getDmg();
        }
    }

    public String getStats() {
        return "Hp:" + hp + " | Gold:" + gold + " | Atak:" + dmg;
    }
}
