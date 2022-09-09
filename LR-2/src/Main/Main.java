package Main;
import Student.Student;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the amount of students: ");
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        Student[] arr = new Student[n];

        try
        {
            createArr(arr,n);
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Cannot find the file");
            System.out.println("The program is complete");
            return;
        }


        while(true){
            System.out.print("Choose the option (0)printing the entire table,(1) print by group, (2) print by faculty, (3) print by junior year, (4) program completion: ");
            switch (in.nextInt()){
                case (0):
                    printTheEntireTable(arr);
                    break;
                case (1):
                    printByGroup(arr);
                    break;
                case(2):
                    printByFaculty(arr);
                    break;
                case (3):
                    printByJuniorYear(arr);
                    break;
                case (4):
                    System.out.println("The program is complete");
                    in.close();
                    return;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
        }

    }

    /**
     * Метод для малювання в консолі шапки таблиці
     */
    public static void PrintTable(){
        PrintLine();
        System.out.println("|  ID  |                 Name                  |Data of Birthday|          Adressa          |    " +
                "Phone        |           Faculty          | Course | Group |");
        PrintLine();
    }

    public static void PrintLine(){
        System.out.println("+------+---------------------------------------+----------------+---------------------------+----" +
                "-------------+----------------------------+--------+-------+");
    }


    /**
     * Метод для заповнення масиву об'єктів з текстового файлу
     * @param arr масив об'єктів
     * @param n розмірність масиву
     */
    public static void createArr(Student[] arr, int n)throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String path =scanner.nextLine() ;
        File file = new File(path);
        Scanner in = new Scanner(file);

        for(int i = 0; i<n ;i++) {
            arr[i] = new Student();

            arr[i].setId(Integer.parseInt(in.nextLine()));

            arr[i].setName(in.nextLine());

            arr[i].setSurname(in.nextLine());

            arr[i].setPatronymic(in.nextLine());

            arr[i].setAddress(in.nextLine());

            arr[i].setDate(in.nextLine());

            arr[i].setPhone(in.nextLine());

            arr[i].setFaculty(in.nextLine());

            arr[i].setGroup(in.nextLine());

            arr[i].setCourse(Integer.parseInt(in.nextLine()));
        }
        in.close();
    }


    /**
     * Метод для виведення об'єктів за групою у формі тамблиці
     * @param arr масив об'єктів
     */
    public static void printByGroup(Student [] arr){
        String group;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the group: ");
        group = in.nextLine();
        PrintTable();
        for (var e:arr) {
            if( e.getGroup().equals(group)) {
                System.out.println(e);
            }
        }
        PrintLine();
    }

    /**
     * Метод для виведення об'єктів за молодшим роком у формі тамблиці
     * @param arr масив об'єктів
     */
    public static void printByJuniorYear(Student [] arr){
        int year;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the year: ");
        year = in.nextInt();
        PrintTable();
        for (var e:arr) {
            if( year < e.getYear()) {
                System.out.println(e);
            }
        }
        PrintLine();

    }


    /**
     * Метод для виведення об'єктів за факультетом у формі тамблиці
     * @param arr масив об'єктів
     */
    public static void printByFaculty(Student [] arr){
        String faculty;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the faculty: ");
        faculty = in.nextLine();
        PrintTable();
        for (var e:arr) {
            if( e.getFaculty().equals(faculty)) {
                System.out.println(e);
            }
        }
        PrintLine();
    }

    /**
     * Метод для виведення усіх об'єктів у формі тамблиці
     * @param arr масив об'єктів
     */
    public static void printTheEntireTable(Student [] arr){

        PrintTable();
        for (var e:arr) {
            System.out.println(e);
        }
        PrintLine();
    }

}