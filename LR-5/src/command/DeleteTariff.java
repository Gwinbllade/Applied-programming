package command;

public class DeleteTariff implements Command {
    DataBase database;

    public DeleteTariff(DataBase database) {
        this.database = database;
    }

    @Override
    public void execute(){
        database.deleteTariff();
    }
}
