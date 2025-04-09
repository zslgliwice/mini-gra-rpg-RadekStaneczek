package src;

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

        void AddItemToEq(item Item)
        {
            equipment.add(Item);
            System.out.print("Dodano do ekwipunku:\n");
            Item.WriteInfo();
        }
        void DeleteItemFromEq(int index)
        {
            System.out.print("Usunięto z ekwipunku:\n");
            equipment.get(index).WriteInfo();
            equipment.remove(index);
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
            else if(Item instanceof usable)
            {
                hp += ((usable) Item).getHp();
                if(hp > max_hp)
                {
                    hp = max_hp;
                }
            }
        }

        public String getStats() {
            return "Hp:" + hp + " | Gold:" + gold + " | Atak:" + dmg;
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
}
