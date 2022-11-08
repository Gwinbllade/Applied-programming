package database;

import command.CommandResult;
import java.sql.*;

public class DataBase {
    private static Connection connection;

    public CommandResult<String> connectionToBD(String[] args)  {
        String URL = args[0];
        String USERNAME = args[1];
        String PASSWORD = args[2];
        return new CommandResult<String>("Connect succeed","user",true);
    }

    public CommandResult<String> addTariff(String[] args) {
        return new CommandResult<String>("Add tariff succeed","user",true);
    }


    public CommandResult<String> chooseTariff(String[] args){
        return new CommandResult<String>("Tariff choose end!","user",true);
    }


    public CommandResult<String>  updateTariff(String[] args){
        return new CommandResult<String>("Update succeed!","user",true);
    }


    public CommandResult<String> deleteTariff(String[] args){
        return new CommandResult<String>("Delete succeed!","admin",true);
    }


    public CommandResult<String> listTariff(String[] args){
        return new CommandResult<String>("ListTariff end!","user",true);
    }


    public CommandResult<String> displaySubscribers(String[] args) {
        return new CommandResult<String>("Display subscribers succeed!","admin",true);
    }


    public CommandResult<String> register(String[] args){
        return new CommandResult<String>("Register succeed!","user",true);
    }


    public CommandResult<String> logIn(String[] args){
        return new CommandResult<String>("log in succeed!","user",true);
    }

    public CommandResult<String> logOut(String[] args){
        return new CommandResult<String>("log out succeed!","user",true);
    }


    public CommandResult<String> userInformation(String[] args) {
            return new CommandResult<String>("userInformation succeed!","user",true);


    }
}

