package src;

public class AttackHandler {
    Enemy e;
    Player p;

    AttackHandler(Enemy enemy,Player player)
    {
        this.e = enemy;
        this.p = player;
    }
    void Attack(int option)
    {
        int critChance = 0;
        int dmgGiven = 0;
        switch (option)
        {
            case 1:
                critChance = (int) Math.floor(Math.random() * 100 + 1);
                dmgGiven = e.getDmg();
                if (critChance < 25) {
                    dmgGiven *= 2;
                }
                System.out.println(e.getName() + " zaatakował cie i zadał " + dmgGiven);
                p.setHp(p.getHp() - dmgGiven);
                break;
            case 2:
                critChance = (int) Math.floor(Math.random() * 100 + 1);
                dmgGiven = p.getDmg();
                if (critChance < 25) {
                    dmgGiven *= 2;
                }
                System.out.println("Zaatakowałeś " + e.getName() +"a i zadałeś mu " + dmgGiven + " dmg\nZostało mu " + e.getHp() + " hp");
                e.setHp(e.getHp() - dmgGiven);
                break;
        }
    }
}
