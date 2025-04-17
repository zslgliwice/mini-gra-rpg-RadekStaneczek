import src.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException
    {
        int n;
        do {
            System.out.println("\n|Leśna przygoda|\n");
            System.out.println("1.New Game\n2.Continue\n3.NG+(Startujesz na difficulty 20)\n4.Infinite\n5.Exit");
            System.out.println("\033[H\033[2J");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Podaj poziom trudności na którym chcesz zagrać");
                    System.out.println("\033[H\033[2J");
                    int input = sc.nextInt();
                    Game.SetDifficulty(input);
                    Game.Play();
                    break;
                case 2:
                    try {
                        Game.LoadPlayer();
                    } catch (Exception e) {
                    }
                    Game.Play();
                    break;
                case 3:
                    try {
                        Game.LoadPlayer();
                    } catch (Exception e) {
                    }
                    Game.SetDifficulty(20);
                    Game.Play();
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
            }
        }while(n != 5);
    }
}