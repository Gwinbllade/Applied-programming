package command;

public class UpdateTariff implements Command{
    DataBase database;

    public UpdateTariff(DataBase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.updateTariff();
    }
}
