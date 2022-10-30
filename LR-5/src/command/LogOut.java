package command;

public class LogOut implements Command{
    DataBase database;

    public LogOut(DataBase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.logOut();
    }
}
