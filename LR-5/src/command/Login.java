package command;

import user.User;

public class Login implements UserCommand {
    DataBase database;

    public Login(DataBase dataBase) {
        this.database = dataBase;
    }

    @Override
    public void execute(User user) {
        database.login(user);
    }
}
