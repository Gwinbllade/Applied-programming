package command;

import user.User;

public class DataBase {
    public void addTariff(){
        System.out.println("add Tariff");
    }


    public void updateTariff(){
        System.out.println("Update tariff");
    }


    public void deleteTariff(){
        System.out.println("delete Tariff");
    }


    public void chooseTariff(){
        System.out.println("Choose Tariff");
    }


    public void listTariff(){
        System.out.println("List tariff");
    }

    public void displaySubscribers(){
        System.out.println("Display subscribers");
    }

    public void register(User user){
        System.out.println("Register");
    }

    public void login(User user){
        System.out.println("login");
    }

    public void logOut(){
        System.out.println("Log Out ");
    }
}
