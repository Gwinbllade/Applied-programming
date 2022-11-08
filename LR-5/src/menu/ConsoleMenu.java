package menu;

import command.*;
import database.DataBase;
import user.User;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleMenu {
    private final DataBase database;

    public ConsoleMenu(DataBase database) {
        this.database = database;
    }

    public void StandartConsoleMenu(){

        Scanner in = new Scanner(System.in);
        User user = new User(new ConnectionToBD(database));

        user.setCommands(0, new LogOut(database));
        user.setCommands(1, new Register(database));
        user.setCommands(2,new LogIn(database));
        user.setCommands(3,new Help());


        int action = -1;

        while (action != 0) {
            CommandResult<String> result = user.RunConnect( new String[]{"URL",
                    "USER","PASSWORD"});
            System.out.println(result.getResult());
            if(!result.isSucceed()){
                System.out.println("Critical error");
                break;
            }

            System.out.print("\n\t\t\t***Standart Menu***\n\t->Select action: 1(Register), 2(Login) 3(Help),0(Exit): ");
            action = Integer.parseInt(in.nextLine());

            try {
                result = user.pressButton(action);
                System.out.println(result.getResult());
                if (action == 2 && result.isSucceed() ) {
                    if (Objects.equals(result.getUserLogin(), "admin")) {
                        AdminMenu(database);
                    }
                    else {
                        SubscriberMenu(database,result.getUserLogin());
                    }

                }
            }
            catch (Exception e){
                System.out.println("Error");
            }


        }
    }


    public static void AdminMenu(DataBase database){
        System.out.println("\n\t***Admin menu***");
        Scanner in = new Scanner(System.in);
        User admin = new User(new ConnectionToBD(database));
        int action = -1;

        admin.setCommands(0, new LogOut(database));
        admin.setCommands(1, new AddTariff(database));
        admin.setCommands(2, new DeleteTariff(database));
        admin.setCommands(3, new DisplaySubscribers(database));
        admin.setCommands(4, new UpdateTariff(database));
        admin.setCommands(5,new TariffList(database));


        while(action != 0){
            System.out.print("\t\t->Select admin action (1)Add Tariff,(2)Delete tariff,(3)Display Subscribers,(4)Update Tariff,(5)Tariff List: ");
            action = Integer.parseInt(in.nextLine());

            try {
                CommandResult<String> result = admin.pressButton(action);
                System.out.println(result.getResult());
            }
            catch (Exception e){
                System.out.println("Error");
            }

        }
    }


    public static void SubscriberMenu(DataBase database, String login){
        System.out.println("\n\t\t***Subscriber menu***");
        Scanner in = new Scanner(System.in);
        User subscriber = new User(new ConnectionToBD(database));
        subscriber.setLoginUser(login);
        subscriber.setCommands(0, new LogOut(database));
        subscriber.setCommands(1, new TariffList(database));
        subscriber.setCommands(2, new ChooseTariff(database));
        subscriber.setCommands(3, new UserInformation(database));

        int action = -1;
        while(action != 0){
            System.out.print("\t\t------->Select subscriber action(1)List tariff, (2) choose tariff, (3) user information (0) LogOut: ");
            action = Integer.parseInt(in.nextLine());

            try {
                CommandResult<String> result = subscriber.pressButton(action);
                System.out.println(result.getResult());
            }
            catch (Exception e){
                System.out.println("Error");
            }

        }
    }
}
