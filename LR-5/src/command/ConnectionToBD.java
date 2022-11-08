package command;

import database.DataBase;


public class ConnectionToBD implements Command{
    DataBase database;

    public ConnectionToBD(DataBase database) {
        this.database = database;
    }

    @Override
    public CommandResult<String> execute(String[] args)  {
        return database.connectionToBD(args);
    }


}
