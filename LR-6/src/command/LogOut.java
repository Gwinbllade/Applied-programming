package command;

import database.DataBase;

public class LogOut implements Command{
    DataBase database;

    public LogOut(DataBase database) {
        this.database = database;
    }

    @Override
    public CommandResult<String> execute(String[] args) {
        return database.logOut(args);
    }
}
