package user;

import command.Command;
import command.UserCommand;


public class User {
    protected String loginUser;
    protected String Password;

    protected UserCommand login;
    protected Command logOut;
    protected Command tariffList;
    protected UserCommand register;

    public User(UserCommand login, Command logOut, Command tariffList, UserCommand register) {
        this.login = login;
        this.logOut = logOut;
        this.tariffList = tariffList;
        this.register = register;
    }

    public void RunLogin(){
        login.execute(this);
    }

    public void RunLogOut(){
        logOut.execute();
    }

    public void RunTariffList() {tariffList.execute();}

    public void RunRegister() {register.execute(this);}
}

