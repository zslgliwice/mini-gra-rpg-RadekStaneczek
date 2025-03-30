package src;

import java.util.Scanner;

public class Game {
    static Player Player = new Player();
    static boolean escaped = false;
    static Scanner sc = new Scanner(System.in);
    public static void Play() throws Exception {
        System.out.println("Witaj w tajemniczym lesie");
        do {
            WriteInfo();
            String input = sc.nextLine();
            if(input.equals("1")){}
            else if(input.equals("2")){
                try{
                    Player.WriteEq();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            else if(input.equals("3")){
                break;
            }
            else{
                System.out.println("Nie ma takiej opcji");
            }
        }
        while(Player.getHp() > 0 || escaped == false);
    }
    public static void WriteInfo()
    {
        System.out.println("Twoje statystyki: " + Player.getStats());
        System.out.println("Co chcesz zrobić?");
        System.out.println("1.Eksplorować dalej");
        System.out.println("2.Sprawdzić ekwipunek");
        System.out.println("3.Zakończyć grę");
    }

}
