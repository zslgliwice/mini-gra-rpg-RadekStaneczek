import src.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException
    {
            System.out.println("1.New Game\n2.Continue\n3.NG+(Startujesz na difficulty 20)\n4.Infinite\n5.Exit");
            System.out.println("\033[H\033[2J");
            System.out.println("Podaj poziom trudności na którym chcesz zagrać");
            System.out.println("\033[H\033[2J");
            int n = sc.nextInt();
            Game.SetDifficulty(n);
            Game.Play();
    }
}