package command;

public class DisplaySubscribers implements Command{
    DataBase database;

    public DisplaySubscribers(DataBase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.displaySubscribers();
    }
}
