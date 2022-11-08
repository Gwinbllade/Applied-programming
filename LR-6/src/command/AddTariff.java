package command;

import database.DataBase;

public class AddTariff implements Command{
    DataBase database;
    public AddTariff( DataBase database){
        this.database = database;
    }

    @Override
    public CommandResult<String> execute(String[] args){

        return database.addTariff(args);
    }
}
