package database;

import command.CommandResult;
import tariff.Tariff;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class DataBase {
    private static Connection connection;

    public CommandResult<String> connectionToBD(String[] args)  {
        String URL = args[0];
        String USERNAME = args[1];
        String PASSWORD = args[2];
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            return new CommandResult<String>("Connect failed","user",false);
        }
        return new CommandResult<String>("Connect successful!","user",true);
    }

    public CommandResult<String> addTariff(String[] args) {
        System.out.println("\t\tadd Tariff");
        Scanner in = new Scanner(System.in);
        Tariff tariff = new Tariff();

        int buffInt, action;
        String buffStr;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            while (true) {
                System.out.println("Enter a  value for the tariff parameter");

                System.out.printf("Name(%s): ", tariff.getName());
                buffStr = in.nextLine();
                tariff.setName("-1".equals(buffStr) ? tariff.getName() : buffStr);

                System.out.printf("subscription Fee(%d): ", tariff.getSubscriptionFee());
                buffInt = Integer.parseInt(in.nextLine());
                tariff.setSubscriptionFee(buffInt == -1 ? tariff.getSubscriptionFee() : buffInt);

                System.out.printf("minutesByOperator(%d): ", tariff.getMinutesByOperator());
                buffInt = Integer.parseInt(in.nextLine());
                tariff.setMinutesByOperator(buffInt == -1 ? tariff.getMinutesByOperator() : buffInt);

                System.out.printf("minunesOtherOperators(%d): ", tariff.getMinunesOtherOperators());
                buffInt = Integer.parseInt(in.nextLine());
                tariff.setMinunesOtherOperators(buffInt == -1 ? tariff.getMinunesOtherOperators() : buffInt);

                System.out.printf("SMS(%d): ", tariff.getSMS());
                buffInt = Integer.parseInt(in.nextLine());
                tariff.setSMS(buffInt == -1 ? tariff.getSMS() : buffInt);

                System.out.printf("mobileData(%d): ", tariff.getMobileData());
                buffInt = Integer.parseInt(in.nextLine());
                tariff.setMobileData(buffInt == -1 ? tariff.getMobileData() : buffInt);

                System.out.printf("priceAdditionalMinute(%d): ", tariff.getPriceAdditionalMinute());
                buffInt = Integer.parseInt(in.nextLine());
                tariff.setPriceAdditionalMinute(buffInt == -1 ? tariff.getPriceAdditionalMinute() : buffInt);

                System.out.printf("priceAdditionalSMS(%d): ", tariff.getPriceAdditionalSMS());
                buffInt = Integer.parseInt(in.nextLine());
                tariff.setPriceAdditionalSMS(buffInt == -1 ? tariff.getPriceAdditionalSMS() : buffInt);

                System.out.printf("priceAdditionalMB(%d): ", tariff.getPriceAdditionalMB());
                buffInt = Integer.parseInt(in.nextLine());
                tariff.setPriceAdditionalMB(buffInt == -1 ? tariff.getPriceAdditionalMB() : buffInt);

                System.out.printf("specialCondition(%s): ", tariff.getSpecialCondition());
                buffStr = in.nextLine();
                tariff.setSpecialCondition("-1".equals(buffStr) ? tariff.getSpecialCondition() : buffStr);

                System.out.println("Save changes(1), edit(0)");
                action = Integer.parseInt(in.nextLine());
                switch (action) {
                    case (0) -> System.out.println("Edit");
                    case (1) -> {
                        System.out.println("Save changes\n");
                        statement.executeUpdate(String.format("INSERT INTO Tariff " +
                                        "VAlUES('%s',%d,%d, %d,%d, %d, %d,  %d, %d,'%s')"
                                , tariff.getName(), tariff.getSubscriptionFee(), tariff.getMinutesByOperator(),
                                tariff.getMinunesOtherOperators(), tariff.getSMS(), tariff.getMobileData(),
                                tariff.getPriceAdditionalMinute(), tariff.getPriceAdditionalSMS(), tariff.getPriceAdditionalMB(),
                                tariff.getSpecialCondition()));
                        return new CommandResult<String>("Add tariff succeed","user",true);
                    }
                    default -> System.out.println("Error");
                }
            }
        } catch (SQLException e) {
            return new CommandResult<String>("Add tariff false","user",false);
        }
    }


    public CommandResult<String> chooseTariff(String[] args){
        String LoginUser = args[0];
        System.out.println("\t\tChoose Tariff");
        ResultSet resultSet;
        Scanner in = new Scanner(System.in);
        int action, ID;
        while (true) {
            System.out.print("Show list of tariffs(1) choose tariff(2) menu(0): ");
            action = Integer.parseInt(in.nextLine());
            switch (action) {
                case (1):
                    this.listTariff(args);
                    break;
                case(2):
                    try {
                        Statement statement = connection.createStatement();
                        System.out.print("Enter the ID tariff that you want to choose: ");
                        ID = Integer.parseInt(in.nextLine());
                        resultSet = statement.executeQuery(String.format("SELECT COUNT (*) FROM Tariff WHERE TariffID = %d", ID));
                        resultSet.next();
                        if (resultSet.getInt(1) == 1){
                            statement.executeUpdate((String.format("UPDATE Client SET TariffID = %d WHERE [PhoneNumber] = '%s'",ID,LoginUser) ) );
                            System.out.println("Update complete");
                            return new CommandResult<String>("Tariff choose succeed",LoginUser,true);
                        }
                        else{
                            System.out.println("There is no such tariff");
                            break;
                        }

                    } catch (SQLException e) {
                        return new CommandResult<String>("Tariff choose  false!",LoginUser,false);
                    }

                case(0):
                    return new CommandResult<String>("Tariff choose end!",LoginUser,true);
                default: System.out.println("Error");
            }
        }
    }


    public CommandResult<String>  updateTariff(String[] args){
        String LoginUser = args[0];
        Scanner in = new Scanner(System.in);
        ResultSet resultSet;
        Tariff tariff;
        int ID, action,buffInt;
        String buffStr;
        while (true) {
            System.out.println("\t\tUpdate tariff\n");
            System.out.print("Show list of tariffs(1) update tariff(2) menu(0): ");
            action = Integer.parseInt(in.nextLine());
            switch (action){
                case(1):
                    this.listTariff(args);
                    break;
                case(2):
                    try {
                        Statement statement = connection.createStatement();
                        System.out.print("Enter the ID tariff that you want to update: ");
                        ID = Integer.parseInt(in.nextLine());
                        resultSet = statement.executeQuery(String.format("SELECT COUNT (*) FROM Tariff " +
                                "WHERE TariffID = %d", ID));
                        resultSet.next();
                        if (resultSet.getInt(1) == 1){
                            resultSet = statement.executeQuery(String.format("SELECT * FROM Tariff " +
                                    "WHERE TariffID = %d", ID));
                            resultSet.next();
                            tariff = new Tariff(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),
                                    resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getInt(9),
                                    resultSet.getInt(10),resultSet.getString(11));

                            while (true){
                                System.out.println("Enter a new value for the tariff parameter (-1) do not change the value");

                                System.out.printf("Name(%s): ",tariff.getName());
                                buffStr = in.nextLine();
                                tariff.setName("-1".equals(buffStr) ? tariff.getName() : buffStr);

                                System.out.printf("subscription Fee(%d): ",tariff.getSubscriptionFee());
                                buffInt = Integer.parseInt(in.nextLine());
                                tariff.setSubscriptionFee(buffInt <= -1? tariff.getSubscriptionFee():buffInt);

                                System.out.printf("minutesByOperator(%d): ",tariff.getMinutesByOperator());
                                buffInt = Integer.parseInt(in.nextLine());
                                tariff.setMinutesByOperator(buffInt <= -1?tariff.getMinutesByOperator():buffInt );

                                System.out.printf("minunesOtherOperators(%d): ",tariff.getMinunesOtherOperators());
                                buffInt = Integer.parseInt(in.nextLine());
                                tariff.setMinunesOtherOperators(buffInt <= -1?tariff.getMinunesOtherOperators():buffInt );

                                System.out.printf("SMS(%d): ",tariff.getSMS());
                                buffInt = Integer.parseInt(in.nextLine());
                                tariff.setSMS(buffInt <= -1?tariff.getSMS():buffInt );

                                System.out.printf("mobileData(%d): ",tariff.getMobileData());
                                buffInt = Integer.parseInt(in.nextLine());
                                tariff.setMobileData(buffInt <= -1?tariff.getMobileData():buffInt );

                                System.out.printf("priceAdditionalMinute(%d): ",tariff.getPriceAdditionalMinute());
                                buffInt = Integer.parseInt(in.nextLine());
                                tariff.setPriceAdditionalMinute(buffInt <= -1?tariff.getPriceAdditionalMinute():buffInt );

                                System.out.printf("priceAdditionalSMS(%d): ",tariff.getPriceAdditionalSMS());
                                buffInt = Integer.parseInt(in.nextLine());
                                tariff.setPriceAdditionalSMS(buffInt <= -1?tariff.getPriceAdditionalSMS():buffInt );

                                System.out.printf("priceAdditionalMB(%d): ",tariff.getPriceAdditionalMB());
                                buffInt = Integer.parseInt(in.nextLine());
                                tariff.setPriceAdditionalMB(buffInt <= -1  ?tariff.getPriceAdditionalMB():buffInt );

                                System.out.printf("specialCondition(%s): ",tariff.getSpecialCondition());
                                buffStr = in.nextLine();
                                tariff.setSpecialCondition("-1".equals(buffStr) ? tariff.getSpecialCondition() : buffStr);

                                System.out.print("Save changes(1), edit(0): ");
                                action = Integer.parseInt(in.nextLine());
                                switch (action) {
                                    case (0) -> System.out.println("Edit");
                                    case (1) -> {
                                        System.out.println("Save changes\n");
                                        statement.executeUpdate(String.format("UPDATE Tariff " +
                                                        "SET [Name] = '%s',Price = %d,MinutesByOperator = %d,MinutesOtherOperators = %d, " +
                                                        "SMS = %d, MB = %d, PriceAdditionalMinute = %d, PriceAdditionalSMS = %d,PriceAdditional_100MB = %d, " +
                                                        "SpecialCondition = '%s' " +
                                                        "WHERE TariffID = %d", tariff.getName(), tariff.getSubscriptionFee(), tariff.getMinutesByOperator(),
                                                tariff.getMinunesOtherOperators(), tariff.getSMS(), tariff.getMobileData(),
                                                tariff.getPriceAdditionalMinute(), tariff.getPriceAdditionalSMS(), tariff.getPriceAdditionalMB(),
                                                tariff.getSpecialCondition(), ID));
                                        return new CommandResult<String>("Update succeed!",LoginUser,true);
                                    }
                                    default -> System.out.println("Error");
                                }
                            }
                        }
                        else {
                            System.out.println("Such a tariff does not exist");
                        }


                    } catch (Exception e) {
                        return new CommandResult<String>("Update failed!",LoginUser,false);
                    }
                case(0):
                    return new CommandResult<String>("Update succeed!",LoginUser,true);
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }


    public CommandResult<String> deleteTariff(String[] args){
        String LoginUser = args[0];
        Scanner in = new Scanner(System.in);
        ResultSet resultSet;
        int action, ID;
        boolean result = false;
        while (true) {
            System.out.print("Show list of tariffs(1) remove tariff(2) menu(0): ");
            action = Integer.parseInt(in.nextLine());
            switch (action){
                case(1):
                    this.listTariff(args);
                    break;
                case(2):
                    try {
                        Statement statement = connection.createStatement();
                        System.out.println("Enter the ID tariff that you want to delete ");
                        ID = Integer.parseInt(in.nextLine());
                        resultSet = statement.executeQuery(String.format("SELECT COUNT (*) FROM Tariff " +
                                "WHERE TariffID = %d", ID));
                        resultSet.next();
                        if (resultSet.getInt(1) == 1){
                            statement.executeUpdate(String.format("DELETE FROM Tariff " +
                                    "WHERE TariffID = %d", ID));
                        }
                        else {
                            System.out.println("Such a tariff does not exist");
                        }

                    } catch (SQLException e) {
                        return new CommandResult<String>("Delete failed!",LoginUser,false);
                    }
                    break;
                case(0):
                    return new CommandResult<String>("Delete succeed!",LoginUser,true);
                default:
                    System.out.println("Error def");
                    break;
            }
        }

    }


    public CommandResult<String> listTariff(String[] args){
        String LoginUser = args[0];
        int maxPrice ,minPrice ,numberOfSMS, minutesByOperator,minutesOtherOperator, mobileDataMB, buff;
        String line =    "+-----+------------------+-------+-----------------+---------------------+-----+----------+-------------" +
                "--------+------------------+---------------------+------------------------------------------------+";

        Scanner in = new Scanner(System.in);
        int mode;
        ResultSet resultSet;
        while(true){
            System.out.print("List tariff(1)No sorting (2)With sorting (0)Exit: ");
            mode = Integer.parseInt(in.nextLine());
            switch (mode) {
                case (1):
                    try {

                        Statement statement = connection.createStatement();

                        resultSet = statement.executeQuery("SELECT * FROM Tariff ");
                        System.out.println(line);
                        System.out.print("|ID   |       Name       | Price |MinutesByOperator|MinutesOtherOperators| " +
                                "SMS |    MB    |PriceAdditionalMinute|PriceAdditionalSMS|PriceAdditional_100MB|                SpecialCondition                |\n");
                        System.out.println(line);

                        while (resultSet.next()) {
                            System.out.printf("|%-5d|%-18s|%-7s|%-17s|%-21s|%-5s|%-10s|%-21s|%-18s|%-21s|%-48s|\n", resultSet.getInt(1), resultSet.getString(2),
                                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                                    resultSet.getString(10), resultSet.getString(11));
                            System.out.println(line);
                        }
                        break;
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                case (2):
                    System.out.println("Enter 0 if the parameter is not needed when sorting");
                    System.out.print("Min price(0 if the parameter is not needed when sorting):");
                    buff = Integer.parseInt(in.nextLine());
                    minPrice = (Math.max(buff, 0));
                    System.out.print("Max price(10000 if the parameter is not needed when sorting):");
                    buff = Integer.parseInt(in.nextLine());
                    maxPrice = (buff>0 ? buff : 100_000);
                    System.out.print("Min number of SMS");
                    buff = Integer.parseInt(in.nextLine());
                    numberOfSMS = (Math.max(buff, 0));
                    System.out.print("Min the number of operator minutes");
                    buff = Integer.parseInt(in.nextLine());
                    minutesByOperator = (Math.max(buff, 0));
                    System.out.print("Min the number of minutes for other operators");
                    buff = Integer.parseInt(in.nextLine());
                    minutesOtherOperator = (Math.max(buff, 0));
                    System.out.print("Min amount of mobile data (MB)");
                    buff = Integer.parseInt(in.nextLine());
                    mobileDataMB = (Math.max(buff, 0));

                    try {

                        Statement statement = connection.createStatement();
                        resultSet = statement.executeQuery(String.format("SELECT COUNT(*) FROM Tariff " +
                                        "WHERE [Price]>=%d AND [Price]<=%d AND [SMS] >= %d AND [MinutesByOperator]>=%d AND [MinutesOtherOperators]>=%d AND [MB]>=%d ",
                                minPrice,maxPrice,numberOfSMS,minutesByOperator,minutesOtherOperator,mobileDataMB));
                        resultSet.next();

                        if (resultSet.getInt(1) == 0 ){
                            System.out.println("There is no tariff for such parameters");
                            break;
                        }

                        resultSet = statement.executeQuery(String.format("SELECT * FROM Tariff " +
                                "WHERE [Price]>=%d AND [Price]<=%d AND [SMS] >= %d AND [MinutesByOperator]>=%d AND [MinutesOtherOperators]>=%d AND [MB]>=%d ",
                                minPrice,maxPrice,numberOfSMS,minutesByOperator,minutesOtherOperator,mobileDataMB));


                        System.out.println(line);
                        System.out.print("|ID   |       Name       | Price |MinutesByOperator|MinutesOtherOperators| " +
                                "SMS |    MB    |PriceAdditionalMinute|PriceAdditionalSMS|PriceAdditional_100MB|                SpecialCondition                |\n");
                        System.out.println(line);

                        while (resultSet.next()) {
                            System.out.printf("|%-5d|%-18s|%-7s|%-17s|%-21s|%-5s|%-10s|%-21s|%-18s|%-21s|%-48s|\n", resultSet.getInt(1), resultSet.getString(2),
                                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                                    resultSet.getString(10), resultSet.getString(11));
                            System.out.println(line);
                        }
                        break;
                    } catch (Exception e) {
                        return new CommandResult<String>("List tariff failed!",LoginUser,false);
                    }

                case (0):
                    System.out.println("Exit");
                    return new CommandResult<String>("List tariff succeed!",LoginUser,true);

                default:
                    System.out.print("Error");
                    break;
        }


        }

    }


    public CommandResult<String> displaySubscribers(String[] args) {
        String LoginUser = args[0];
        System.out.println("Display subscribers");
        ResultSet resultSet;
        String line = "+-----+-------------+-------------------------+-----------------+-----------------+--------+";
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT [ClientID],[PhoneNumber],[Surname],[Name],[Patronymic],[TariffID] FROM Client");
            System.out.println(line);
            System.out.print("|ID   |PhoneNumber  |         Surname         |      Name       |   Patronymic    |TariffID|\n");
            System.out.println(line);
            while(resultSet.next()){
                System.out.printf("|%-5d|%-13s|%-25s|%-17s|%-17s|%-8s|\n",resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6) );
                System.out.println(line);
            }

        } catch (SQLException e) {
            return new CommandResult<String>("Display subscribers failed!",LoginUser,false);
        }
        return new CommandResult<String>("Display subscribers succeed!",LoginUser,true);
    }


    public CommandResult<String> register(String[] args){
        String LoginUser = args[0];
        Scanner input = new Scanner(System.in);
        String name,patronymic,surname,password, phoneNumber;
        ResultSet resultSet;
        System.out.print("Enter your name: ");
        name = input.nextLine();
        System.out.print("Enter your surname: ");
        surname = input.nextLine();
        System.out.print("Enter your patronymic: ");
        patronymic = input.nextLine();
        while (true) {
            System.out.print("Enter your phone number: ");
            phoneNumber = input.nextLine();
            if (phoneNumber.length() == 12 && phoneNumber.matches("38(\\d{10})")) {
                    break;
                }
            else {
                System.out.println("The number was entered incorrectly");
             }
        }

        System.out.print("Enter your Password: ");
        password = input.nextLine();
        try {
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(String.format("SELECT COUNT(*) FROM Client " +
                    "WHERE PhoneNumber = '%s'",phoneNumber));
            resultSet.next();

            if(resultSet.getInt(1) == 0) {

                statement.executeUpdate(String.format("INSERT INTO Client " +
                        "VALUES('%s','%s','%s','%s','%s',null)",password,phoneNumber,surname,name,patronymic));
                return new CommandResult<String>("Register succeed!",LoginUser,true);

            }
            else {
                return new CommandResult<String>("Register failed(The user with this number is registered)",LoginUser,false);
            }
        } catch (Exception e) {
            return new CommandResult<String>("Register failed!",LoginUser,false);
        }



    }


    public CommandResult<String> logIn(String[] args){
        boolean result = true;
        ResultSet resultSet;
        System.out.println("\t\tLogin");
        String login, password;
        try {
            Scanner input = new Scanner(System.in);
            Statement statement = connection.createStatement();
            System.out.print("Enter the login(number phone):" );
            login = input.nextLine();
            System.out.print("Enter the password:" );
            password = input.nextLine();

            if (Objects.equals(login, "admin") && Objects.equals(password, "12345678")){
                return new CommandResult<String>("Log in admin succeed!","admin",true);
            }

            resultSet = statement.executeQuery(String.format("SELECT COUNT(ClientID) FROM  Client " +
                    "WHERE Password = '%s' and PhoneNumber = '%s'", password,login));
            resultSet.next();


            if(resultSet.getInt(1) == 1) {
                return new CommandResult<String>("Log in subscribers succeed!",login,true);

            }
            else{
                System.out.print("The error is an incorrect login or password");
                return new CommandResult<String>("Log in subscribers failed!","user",false);
            }

            } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public CommandResult<String> logOut(String[] args){
        String LoginUser = args[0];
        try {
            connection.close();
        } catch (SQLException e) {
            return new CommandResult<String>("Log out failed!",LoginUser,false);
        }
        return new CommandResult<String>("Log out succeed!",LoginUser,true);
    }


    public CommandResult<String> userInformation(String[] args) {
        String userLogin = args[0];
        ResultSet resultSet;
        String line = "+-----+-------------+-------------------------+-----------------+-----------------+--------+";
        try {
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(String.format("SELECT ClientID,PhoneNumber,Surname,Name,Patronymic,TariffID FROM [Client] " +
                    "WHERE PhoneNumber = '%s'", userLogin));
            resultSet.next();
            System.out.println(line);
            System.out.print("|ID   |PhoneNumber  |         Surname         |      Name       |   Patronymic    |TariffID|\n");
            System.out.println(line);
            System.out.printf("|%-5d|%-13s|%-25s|%-17s|%-17s|%-8s|\n",resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6) );
            System.out.println(line);
            return new CommandResult<String>("User information succeed!",userLogin,true);


        } catch (SQLException e) {
            return new CommandResult<String>("User information failed!",userLogin,false);

        }

    }
}

