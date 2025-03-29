public class item
{
    String name;
    String desc;

    public item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    void WriteInfo() {
        System.out.println(name);
        System.out.println(desc);
    }
}
class weapon extends item
{
    int dmg;
    weapon(String name,String desc,int dmg) {
        super(name,desc);
        this.dmg = dmg;
    }
}

