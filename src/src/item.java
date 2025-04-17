package src;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = weapon.class, name = "weapon"),
        @JsonSubTypes.Type(value = usable.class, name = "usable")
})
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public void setDmg(int dmg) {
        this.dmg = dmg;
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

    public void setHp(int hp) {
        this.hp = hp;
    }
}

