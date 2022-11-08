package command;

public class CommandResult<T> {
    private T Result;
    private String UserLogin;
    private boolean IsSucceed;

    public CommandResult(T result, String userLogin, boolean isSucceed) {
        Result = result;
        UserLogin = userLogin;
        IsSucceed = isSucceed;
    }

    public T getResult() {
        return Result;
    }


    public String getUserLogin() {
        return UserLogin;
    }


    public boolean isSucceed() {
        return IsSucceed;
    }


    public String Result() {
        return "CommandResult{" +
                "Result=" + Result +
                ", UserLogin='" + UserLogin + '\'' +
                ", IsSucceed=" + IsSucceed +
                '}';
    }
}
