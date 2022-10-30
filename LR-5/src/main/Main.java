package main;

import command.*;
import user.User;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        ConsoleMenu(database);
    }

    public static void ConsoleMenu(DataBase database){
        Scanner in = new Scanner(System.in);
        User user = new User(new Login(database), new LogOut(database), new TariffList(database), new Register(database));
        int action;
        while (true) {
            System.out.println("Chose action: 1(Register), 2(Login)");
            action = Integer.parseInt (in.nextLine());
            switch (action) {
                case (1):
                    user.RunRegister();
                    break;

                case(2):
                    user.RunLogin();
            }
            break;
        }
    }
}