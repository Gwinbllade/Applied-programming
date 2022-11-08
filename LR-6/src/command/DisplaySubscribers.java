package command;

import database.DataBase;

public class DisplaySubscribers implements Command{
    DataBase database;

    public DisplaySubscribers(DataBase database) {
        this.database = database;
    }

    @Override
    public CommandResult<String> execute(String[] args) {

        return database.displaySubscribers(args);
    }
}
