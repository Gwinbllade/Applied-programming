package battleArena;
import droids.*;
import java.util.Scanner;
import text.Text;

public class Arena {
    public static final String ANSI_BLACK = "\u001B[30m";
    private final BaseDroid[] teamFirst;
    private final BaseDroid[] teamSecond;
    private int sizeFT;
    private int sizeST;


    public Arena() {
        int size, typeOfDroid;

        Scanner input = new Scanner(System.in);
        System.out.print(Text.BLUE + "\n     Enter the size of the first command: "+ Text.BLUE);
        size = Integer.parseInt(input.nextLine());
        this.sizeFT = size;

        this.teamFirst = new BaseDroid[size];
        completingCommands(this.teamFirst);

        System.out.print(Text.RED + "\n     Enter the size of the second command: ");
        size = Integer.parseInt(input.nextLine());
        this.sizeST = size;
        this.teamSecond = new BaseDroid[size];
        completingCommands(this.teamSecond);

        System.out.println(Text.GREEN+"\t\tTeam formation is complete"+ Text.RESET);
    }


    public void PrintTeam(){
        System.out.print(Text.BLUE+"\t\t\tFirst team \n"+Text.RESET);
        for(int i = 0;i< teamFirst.length;i++){
            System.out.printf(Text.BLUE+"%d - %s (%s)\n"+Text.RESET, i+1, teamFirst[i].getName(), teamFirst[i].getType());
        }

        System.out.print(Text.RED+"\t\t\tSecond team \n"+Text.RESET);
        for(int i = 0;i< teamSecond.length;i++){
            System.out.printf(Text.RED+"%d - %s (%s)\n"+Text.RESET, i+1, teamSecond[i].getName(), teamSecond[i].getType());
        }

    }

    public static void completingCommands(BaseDroid[] arr) {
        int typeOfDroid;
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Select droid type: assassin(1), doctor(2), tank(3), vampire(4), droid information(0)");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Select droid type:");
            typeOfDroid = Integer.parseInt(input.nextLine());

            switch (typeOfDroid) {
                case (1):
                    System.out.printf("Enter the name droid(%d): ", i + 1);
                    name = input.nextLine();
                    arr[i] = new Assassin(name);
                    break;
                case (2):
                    System.out.printf("Enter the name droid(%d): ", i + 1);
                    name = input.nextLine();
                    arr[i] = new Doctor(name);
                    break;
                case (3):
                    System.out.printf("Enter the name droid(%d): ", i + 1);
                    name = input.nextLine();
                    arr[i] = new Tank(name);
                    break;
                case (4):
                    System.out.printf("Enter the name droid(%d): ", i + 1);
                    name = input.nextLine();
                    arr[i] = new Vampire(name);
                    break;
                case (0):
                    System.out.print("""
                            (0)Doctor:
                            Health - 100
                            Damage - 5
                            Precision - 80%
                            Special ability: During an attack with a 10% chance to increase health by 5 units \n \n""");
                    System.out.print("""
                            (1)Assassin:
                            Health - 50
                            Damage - 10
                            Precision - 90%
                            Special ability: With a 20% chance to deal double damage \n \n""");
                    System.out.print("""
                            (2)Vampire:
                            Health - 80
                            Damage - 4
                            Precision - 50%
                            Special ability: On a successful attack, heals for 2 units \n \n""");
                    System.out.print("""
                            (3)Vampire:
                            Health - 200
                            Damage - 4
                            Precision - 50%
                            Special ability: no \n \n""");
                    i--;
                    break;
                default:
                    i--;
                    System.out.println("Error. Please enter the type again");
                    break;
            }

        }
    }


    public static boolean Attacked(BaseDroid droid, BaseDroid enemy) {
        boolean kill = false;
        if (droid.attack(enemy)) {
            System.out.printf("%s(%s) attacked  %s(%s)", droid.getName(), droid.getType(),
                    enemy.getName(), enemy.getType());
        } else {
            System.out.printf("%s(%s) missed", droid.getName(), droid.getType());
        }

        if (enemy.getHealth() <= 0) {
            kill = true;
            System.out.printf("\n%s(%s) kill %s(%s)", droid.getName(), droid.getType(),
                    enemy.getName(), enemy.getType());
        }
        System.out.print("\n\n\n");
        return kill;
    }


    public static int removeDroid(BaseDroid[] arr, int indexD, int SizeT) {
        System.arraycopy(arr, indexD + 1, arr, indexD, arr.length - indexD - 1);
        return SizeT - 1;
    }

    public void Fight() {
        System.out.println(Text.RESET +"\t\t Fight");
        int round = 0;
        while (true) {
            round++;
            System.out.printf(Text.GREEN +"------------Round %d---------------\n"+ Text.RESET, round);
            System.out.print(Text.BLUE+"\t\t\tFirst team attacked\n"+Text.RESET);

            for (int i = 0; i < sizeFT; i++) {
                int droidFT = (int) (Math.random() * sizeFT);//індекс дроїда з першої команди
                int droidST = (int) (Math.random() * sizeST);//індекс дроїда з другої команди
                if (Attacked(teamFirst[droidFT], teamSecond[droidST])) {
                    sizeST = removeDroid(teamSecond, droidST, sizeST);
                }
            }

            if (sizeST <= 0) {

                System.out.print(Text.TWFT);
                break;
            }

            System.out.print(Text.RED+"\t\t\t Second team attacked\n"+Text.RESET);
            for (int i = 0; i < sizeST; i++) {
                int droidFT = (int) (Math.random() * sizeFT);//індекс дроїда з першої команди
                int droidST = (int) (Math.random() * sizeST);//індекс дроїда з другої команди
                if (Attacked(teamSecond[droidST], teamFirst[droidFT])) {
                    sizeFT = removeDroid(teamFirst, droidFT, sizeFT);
                }
            }

            if (sizeFT <= 0) {
                System.out.print(Text.TWST);
                break;
            }
        }
    }
}


