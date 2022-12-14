package battleArena;
import droids.*;

import java.io.PrintWriter;
import java.util.Scanner;

import file.FileGames;
import text.*;

public class Arena {
    public static final String ANSI_BLACK = "\u001B[30m";
    private final BaseDroid[] teamFirst;
    private final BaseDroid[] teamSecond;
    private int sizeFT;
    private int sizeST;
    private FileGames file;

    public Arena() {
        file = new FileGames();
        file.CreateFile();
        int size;//Розмір команди

        Scanner input = new Scanner(System.in);
        System.out.print(Text.BLUE + "\n     Enter the size of the first command: "+ Text.BLUE);

        while (true){
            try {
                size = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e){
                System.out.print("Error. Please enter the size again: ");
                continue;
            }
            break;
        }

        this.sizeFT = size;

        this.teamFirst = new BaseDroid[size];
        completingCommands(this.teamFirst);

        System.out.print(Text.RED + "\n     Enter the size of the second command: ");

        while (true){
            try {
                size = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e){
                System.out.print("Error. Please enter the size again: ");
                continue;
            }
            break;
        }

        this.sizeST = size;
        this.teamSecond = new BaseDroid[size];
        completingCommands(this.teamSecond);

        System.out.println(Text.GREEN+"\t\tTeam formation is complete"+ Text.RESET);
    }


    public void PrintTeam(){
        System.out.print(Text.BLUE+"\t\t\tFirst team \n"+Text.RESET);
        file.getFw().printf(Text.BLUE+"\t\t\tFirst team \n");
        for(int i = 0;i< teamFirst.length;i++){
            System.out.printf(Text.BLUE+"%d - %s (%s)\n"+Text.RESET, i+1, teamFirst[i].getName(), teamFirst[i].getType());
            file.getFw().printf(Text.BLUE+"%d - %s (%s)\n"+Text.RESET, i+1, teamFirst[i].getName(), teamFirst[i].getType());
        }

        System.out.print(Text.RED+"\t\t\tSecond team \n"+Text.RESET);
        file.getFw().print(Text.RED+"\t\t\tSecond team \n"+Text.RESET);

        for(int i = 0;i< teamSecond.length;i++){
            System.out.printf(Text.RED+"%d - %s (%s)\n"+Text.RESET, i+1, teamSecond[i].getName(), teamSecond[i].getType());
            file.getFw().printf(Text.RED+"%d - %s (%s)\n"+Text.RESET, i+1, teamSecond[i].getName(), teamSecond[i].getType());
        }

    }

    public static void completingCommands(BaseDroid[] arr) {
        int typeOfDroid;
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Select droid type: assassin(1), doctor(2), tank(3), vampire(4), droid information(0)\n");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Select droid type:");
            try {
                typeOfDroid = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e){
                i--;
                System.out.print("Error. Please enter the type again\n");
                continue;
            }

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
                            (1)Assassin:
                            Health - 50
                            Damage - 10
                            Precision - 90%
                            Special ability: With a 20% chance to deal double damage \n \n""");
                    System.out.print("""
                            (2)Doctor:
                            Health - 100
                            Damage - 5
                            Precision - 80%
                            Special ability: During an attack with a 10% chance to increase health by 5 units \n \n""");
                    System.out.print("""
                            (3)Tank:
                            Health - 200
                            Damage - 4
                            Precision - 50%
                            Special ability: no \n \n""");
                    System.out.print("""
                            (4)Vampire:
                            Health - 80
                            Damage - 4
                            Precision - 50%
                            Special ability: On a successful attack, heals for 2 units \n \n""");

                    i--;
                    break;
                default:
                    i--;
                    System.out.print("Error. Please enter the type again\n");
                    break;
            }

        }
    }


    public static boolean Attacked(BaseDroid droid, BaseDroid enemy, PrintWriter fw, String color1,String color2) {
        boolean kill = false;
        if (droid.attack(enemy, fw) ) {
            System.out.printf(color1+"%s(%s)"+Text.RESET+ "attacked" +color2+" %s(%s)"+Text.RESET, droid.getName(), droid.getType(),
                    enemy.getName(), enemy.getType());
            fw.printf(color1+"%s(%s)"+Text.RESET+ "attacked" +color2+" %s(%s)"+Text.RESET, droid.getName(), droid.getType(),
                    enemy.getName(), enemy.getType());

        } else {
            System.out.printf("%s(%s) missed", droid.getName(), droid.getType());
            fw.printf("%s(%s) missed\n", droid.getName(), droid.getType());
        }

        if (enemy.getHealth() <= 0) {
            kill = true;
            System.out.printf(Text.PURPLE+"\n%s(%s) kill %s(%s)"+Text.RESET, droid.getName(), droid.getType(),
                    enemy.getName(), enemy.getType());
            fw.printf(Text.PURPLE+"\n%s(%s) kill %s(%s)"+Text.RESET, droid.getName(), droid.getType(),
                    enemy.getName(), enemy.getType());
        }
        fw.print("\n");
        System.out.print("\n");
        return kill;
    }


    public static int removeDroid(BaseDroid[] arr, int indexD, int SizeT) {
        System.arraycopy(arr, indexD + 1, arr, indexD, arr.length - indexD - 1);
        return SizeT - 1;
    }

    public void Fight() {

        System.out.print(Text.RESET +"\t\t Fight\n");
        file.getFw().print("\t\t Fight\n");

        int round = 0;

        while (true) {
            round++;
            System.out.printf(Text.GREEN +"------------Round %d---------------\n"+ Text.RESET, round);
            file.getFw().printf(Text.GREEN +"------------Round %d---------------\n"+ Text.RESET, round);

            System.out.print(Text.BLUE+"\t\t\tFirst team attacked\n"+Text.RESET);
            file.getFw().print(Text.BLUE+"\t\t\tFirst team attacked\n"+Text.RESET);

            for (int i = 0; i < sizeFT; i++) {
                int droidFT = (int) (Math.random() * sizeFT);//індекс дроїда з першої команди
                int droidST = (int) (Math.random() * sizeST);//індекс дроїда з другої команди
                if (Attacked(teamFirst[droidFT], teamSecond[droidST], file.getFw(), Text.BLUE, Text.RED)) {
                    sizeST = removeDroid(teamSecond, droidST, sizeST);
                    if(sizeST <= 0){
                        break;
                    }
                }
            }

            if (sizeST <= 0) {//Виграла перша команда
                System.out.print(Text.TWFT);
                file.getFw().print(Text.TWFT);
                break;
            }

            System.out.print(Text.RED+"\t\t\t Second team attacked\n"+Text.RESET);
            file.getFw().print(Text.RED+"\t\t\t Second team attacked\n"+Text.RESET);

            for (int i = 0; i < sizeST; i++) {
                int droidFT = (int) (Math.random() * sizeFT);//індекс дроїда з першої команди
                int droidST = (int) (Math.random() * sizeST);//індекс дроїда з другої команди
                if (Attacked(teamSecond[droidST], teamFirst[droidFT], file.getFw(), Text.RED, Text.BLUE) ) {
                    sizeFT = removeDroid(teamFirst, droidFT, sizeFT);
                    if(sizeFT <= 0){
                        break;
                    }
                }
            }

            if (sizeFT <= 0) {//Виграла друга команда
                System.out.print(Text.TWST);
                file.getFw().print(Text.TWST);
                break;
            }
        }
        file.getFw().close();
    }
}


