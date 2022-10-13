package main;

import battleArena.Arena;
import text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void game() {
        Arena arena = new Arena();
        arena.PrintTeam();
        arena.Fight();
    }


    public static void startGameFromFile(){
        Scanner input = new Scanner(System.in);
        File file;
        Scanner inputFromFile = null;
        String path;
        while (true) {
            System.out.print("Enter the file path: ");
            path = input.nextLine();
            file = new File(path);

            try {
                inputFromFile = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                continue;
            }
            break;
        }

        while (inputFromFile.hasNextLine() ){
            System.out.println(inputFromFile.nextLine());
        }
    }


    public static void main(String[] args) {
        System.out.print(Text.Title);
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nChoose an action: end program(0), start new game(1), start the game from the file (2): ");
            int action;

            while (true){
                try {
                    action = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e){
                    System.out.print("Error. Please enter the action again: ");
                    continue;
                }
                break;
            }

            switch (action) {
                case 0 -> {
                    System.out.println("Exit the program");
                    input.close();
                    return;
                }
                case 1 -> {
                    System.out.println("Star");
                    game();
                }
                case 2 -> {
                    System.out.print("Star from the file\n");
                    startGameFromFile();
                }
                default -> System.out.println("Error");
            }
        }
    }
}
