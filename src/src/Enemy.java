package src;

public class Enemy {
    String name;
    int hp;
    int dmg;
    Enemy(int hp, int dmg, String name)
    {
        this.hp = (int)Math.floor(Math.random() * 80 + 20);
        this.dmg = (int)Math.floor(Math.random() * 20 + 8);
        this.name = name;
    }
    void Attack(Player p)
    {
        int critChance = (int)Math.floor(Math.random() * 100 + 1);
        int dmgGiven = dmg;
        if(critChance < 25)
        {
            dmgGiven *=2;
        }
        System.out.println(this.name + " zaatakował cie i zadał " + dmgGiven);
        p.setHp(p.getHp() - dmgGiven);
    }
}
