package command;

import database.DataBase;

public class DeleteTariff implements Command {
    DataBase database;

    public DeleteTariff(DataBase database) {
        this.database = database;
    }

    @Override
    public CommandResult<String> execute(String[] args){
        return  database.deleteTariff(args);
    }
}
