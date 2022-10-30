package command;

public class ChooseTariff implements Command{
    DataBase database;

    public ChooseTariff(DataBase database) {
        this.database = database;
    }

    @Override
    public void execute(){
        database.chooseTariff();
    }

}
