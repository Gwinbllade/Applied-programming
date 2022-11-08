package user;

import command.Command;
import command.CommandResult;


import java.util.HashMap;
import java.util.Map;


public class User {
    private String loginUser;
    private final Command connectionToBd;
    private final Map<Integer,Command> commands;


    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }


    public User(Command connection){
        commands = new HashMap<>();
        connectionToBd = connection;
    }

    public void setCommands(int button, Command command){
        commands.put(button,command);
    }

    public CommandResult<String> pressButton(int button){
        return commands.get(button).execute(new String[]{loginUser});
    }

    public CommandResult<String> RunConnect(String [] args){
        return connectionToBd.execute(args);

    }

}

