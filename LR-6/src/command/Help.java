package command;

public class Help implements Command{
    @Override
    public CommandResult<String> execute(String[] args) {
        System.out.print("To register, enter (1), then enter your name and phone number (this will be your login) and password.\n" +
                "If you are registered in the system, enter (2) and then enter your login and password");
        return new CommandResult<String>("Help succeed!","user",true);
    }
}
