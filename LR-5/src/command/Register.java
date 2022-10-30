package command;

import user.User;

public class Register implements UserCommand {
    DataBase database;

    public Register(DataBase database) {
        this.database = database;
    }

    @Override
    public void execute(User user) {
        database.register(user);
    }
}
