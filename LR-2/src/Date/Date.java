package Date;
import java.util.Scanner;

/**
 * Допоміжний клас для опису дати
 */

public class Date {
    private int year;
    private int moon;
    private int day;

    private long dateInSecond;

    public Date(){}
    public Date(int year, int moon, int day){
        this.year = year;
        this.moon = moon;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMoon() {
        return moon;
    }

    public int getYear() {
        return year;
    }

    public void InputDate(String dateStr){
        String[] date = dateStr.split("\\.");

        this.day = (Integer.parseInt(date[0]));

        this.moon = (Integer.parseInt(date[1]));

        this.year = (Integer.parseInt(date[2]));
    }

}
