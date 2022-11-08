package command;

import database.DataBase;

public class LogIn implements Command {
    DataBase database;

    public LogIn(DataBase dataBase) {
        this.database = dataBase;
    }

    @Override
    public CommandResult<String> execute(String[] args) {
        return database.logIn(args);
    }
}
