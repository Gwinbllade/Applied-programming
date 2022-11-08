package command;

import database.DataBase;

public class ChooseTariff implements Command{
    DataBase database;

    public ChooseTariff(DataBase database) {
        this.database = database;
    }

    @Override
    public CommandResult<String> execute(String[] args){
        return database.chooseTariff(args);
    }

}
