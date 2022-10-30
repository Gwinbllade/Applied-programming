package command;

public class AddTariff implements Command{
    DataBase database;
    public AddTariff( DataBase database){
        this.database = database;
    }

    @Override
    public void execute(){
        database.addTariff();
    }
}
