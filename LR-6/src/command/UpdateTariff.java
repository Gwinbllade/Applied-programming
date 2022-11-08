package command;

import database.DataBase;

public class UpdateTariff implements Command{
    DataBase database;

    public UpdateTariff(DataBase database) {
        this.database = database;
    }

    @Override
    public CommandResult<String> execute(String[] args) {

        return database.updateTariff(args);
    }
}
