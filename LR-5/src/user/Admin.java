package user;

import command.Command;
import command.UserCommand;

public class Admin extends User{
    Command addTariff;
    Command deleteTariff;
    Command displaySubscribers;
    Command updateTariff;


    public Admin(UserCommand login, Command logOut, Command tariffList, UserCommand register, Command addTariff, Command deleteTariff, Command displaySubscribers, Command updateTariff) {
        super(login, logOut, tariffList, register);
        this.addTariff = addTariff;
        this.deleteTariff = deleteTariff;
        this.displaySubscribers = displaySubscribers;
        this.updateTariff = updateTariff;
    }
}
