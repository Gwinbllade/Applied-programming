import droids.*;
import battleArena.Arena;

import java.util.Scanner;


public class Main {
    public static void game(){
        Arena arena = new Arena();
        System.out.println("\t\t Fight");
        arena.Fight();

    }

    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose an action: end program(0), start new game(1), play game(2)");
            int action = input.nextInt();
            switch (action){
                case(0):
                    System.out.println("Exit the program");
                    input.close();
                    return;
                case(1):
                    System.out.println("Star");
                    game();
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }
}
