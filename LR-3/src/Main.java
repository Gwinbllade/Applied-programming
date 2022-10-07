import droids.*;
import battleArena.Arena;
import text.Text;
import java.util.Scanner;


public class Main {
    public static void game() {
        Scanner input = new Scanner(System.in);
        Arena arena = new Arena();
        int action;
        while (true) {
            System.out.print("\nSelect an action: ");
            action = input.nextInt();
            switch (action) {
                case (0):
                    arena.PrintTeam();
                    break;
                case (1):
                    arena.Fight();
                    return;
                default:
                    System.out.println("Error");
                    break;
            }
        }
}


    public static void main(String[] args) {
        System.out.print(Text.Title);
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nChoose an action: end program(0), start new game(1), start the game from the file (2): ");
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
                case(2):
                    System.out.print("Star from the file");
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }
}
