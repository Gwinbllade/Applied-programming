package command;

import database.DataBase;

public class UserInformation implements Command{
    DataBase database;

    public UserInformation(DataBase dataBase) {
        this.database = dataBase;
    }
    @Override
    public CommandResult<String> execute(String[] args) {

        return database.userInformation(args);
    }
}
