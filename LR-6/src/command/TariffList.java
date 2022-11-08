package command;

import database.DataBase;

public class TariffList implements Command{
    DataBase database;

    public TariffList(DataBase database) {
        this.database = database;
    }

    @Override
    public CommandResult<String> execute(String[] args) {

        return database.listTariff(args);
    }
}
