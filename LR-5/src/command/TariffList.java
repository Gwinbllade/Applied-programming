package command;

public class TariffList implements Command{
    DataBase database;

    public TariffList(DataBase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.listTariff();
    }
}
