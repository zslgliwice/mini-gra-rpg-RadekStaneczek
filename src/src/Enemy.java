package src;

public class Enemy {
    String name;
    int hp;
    int dmg;

    Enemy(int hp, int dmg, String name) {
        this.hp = (int) Math.floor(Math.random() * 80 + 20);
        this.dmg = (int) Math.floor(Math.random() * 20 + 8);
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
