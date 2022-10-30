package user;

import command.Command;
import command.UserCommand;

public class Subscriber extends User{
    Command chooseTariff;
    private int ID;
    private String phone;
    private String name;
    private String surName;
    private String patronymic;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Subscriber(UserCommand login, Command logOut, Command tariffList, UserCommand register, Command chooseTariff) {
        super(login, logOut, tariffList, register);
        this.chooseTariff = chooseTariff;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
