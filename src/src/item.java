package src;

public class item {
    String name;
    String desc;

    public item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    void WriteInfo() {
        System.out.println("\t" + name);
        System.out.println("\t" + desc);
    }
}

class weapon extends item {
    int dmg;

    weapon(String name, String desc, int dmg) {
        super(name, desc);
        this.dmg = dmg;
    }

    @Override
    void WriteInfo() {
        super.WriteInfo();
        System.out.println("\t" + dmg + " dmg");
    }

    public int getDmg() {
        return dmg;
    }

}

class usable extends item {
    int hp;

    usable(String name, String desc, int hp) {
        super(name, desc);
        this.hp = hp;
    }

    @Override
    void WriteInfo() {
        super.WriteInfo();
        System.out.println("\tDodaje " + hp + " hp");
    }

    public int getHp() {
        return hp;
    }
}

