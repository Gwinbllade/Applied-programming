package main;

import database.DataBase;
import menu.ConsoleMenu;


public class Main {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        ConsoleMenu e = new ConsoleMenu(database);
        e.StandartConsoleMenu();
    }
}
