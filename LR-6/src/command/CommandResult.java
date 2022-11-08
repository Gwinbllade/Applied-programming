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

    public void setResult(T result) {
        Result = result;
    }

    public String getUserLogin() {
        return UserLogin;
    }

    public void setUserLogin(String message) {
        UserLogin = message;
    }

    public boolean isSucceed() {
        return IsSucceed;
    }

    public void setSucceed(boolean succeed) {
        IsSucceed = succeed;
    }
    public String Result() {
        return "CommandResult{" +
                "Result=" + Result +
                ", UserLogin='" + UserLogin + '\'' +
                ", IsSucceed=" + IsSucceed +
                '}';
    }
}
