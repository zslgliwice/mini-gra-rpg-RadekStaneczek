import src.Game;
import src.itemHandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    static ArrayList<src.item> Items = new ArrayList<>();
    static itemHandler itemHandler;

    static {
        try {
            itemHandler = new itemHandler();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws Exception {
        Items.addAll(itemHandler.getItems());

        Game.Play();
    }
}