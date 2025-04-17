package src;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Scanner;


public class Player {
    int hp = 100;
    int max_hp = 100;
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

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    void AddItemToEq(item Item) {
        equipment.add(Item);
        System.out.print("Dodano do ekwipunku:\n");
        Item.WriteInfo();
    }

    void DeleteItemFromEq(int index) {
        System.out.print("Usunięto z ekwipunku:\n");
        equipment.get(index).WriteInfo();
        equipment.remove(index);
    }
    void Equipment() throws Exception{
        try {
            WriteEq();
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
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    void WriteEq() throws Exception {
        if (!equipment.isEmpty()) {
            for (int i = 0; i < equipment.size(); i++) {
                System.out.println();
                System.out.print(Integer.toString(i + 1) + ".");
                equipment.get(i).WriteInfo();
            }
        } else {
            throw new Exception("Masz pusty ekwipunek");
        }
    }

    void Equip(Object Item) {
        if (Item instanceof weapon) {
            dmg = base_dmg + ((weapon) Item).getDmg();
        } else if (Item instanceof usable) {
            hp += ((usable) Item).getHp();
            if (hp > max_hp) {
                hp = max_hp;
            }

        }
    }
    public void checkLvlUp() {
        if (exp >= (lvl+1) * 1000) {
            exp = exp - ((lvl + 1) * 1000);
            lvl += 1;
            max_hp += 10;
            hp = max_hp;
            base_dmg = lvl * base_dmg;
            System.out.println("Masz teraz " + lvl + " poziom");
        }

    }
    @JsonIgnore
    public String getStats() {
        return "Poziom: " + lvl + " | Hp:" + hp + " | Gold:" + gold + " | Atak:" + dmg + " | Exp:[" + WriteExpBar(20) + "]" ;
    }

    private String WriteExpBar(int MaxBars)
    {
        String expBar = "";

        int NextLevel = lvl +1;
        int BarCount = (int) Math.floor((double)exp/(NextLevel*1000)*MaxBars);

        for (int i = 0; i < MaxBars; i++) {

            if(i < BarCount) {
                expBar += "█";
            }
            else{
                expBar += "X";
            }

        }
        return expBar;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getBase_dmg() {
        return base_dmg;
    }

    public void setBase_dmg(int base_dmg) {
        this.base_dmg = base_dmg;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }
}
