package Student;
import Date.Date;


/**
 * Клас для опису студента
 * @author Ihor Bychkovskyi "ihor.bychkovskyi.kn.2021@lpnu.ua"
 * @version 1.0
 */

public class Student {
    private int id;
    private int course;
    private  Date date;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String phone;
    private String group;
    private String faculty;


    public Student(){
        this.date = new Date();
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String dateStr){
        this.date.InputDate(dateStr);
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear(){return date.getYear();}

    public int getCourse() {
        return course;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public String getSurname() {
        return surname;
    }

    /**
     * формування рядку інформації про об'єкт
     * @return рядок інформації про обо'єкт
     */
    public String toString( ) {
        return String.format("| %-5d|%-39s|%4d.%2d.%-8d|%-27s|%-17s|%-28s|    %-4d|%-7s|",id,
        name+' '+surname+' '+patronymic,date.getDay(),date.getMoon(),date.getYear(),
         address,phone,faculty,course,group);
    }
}
