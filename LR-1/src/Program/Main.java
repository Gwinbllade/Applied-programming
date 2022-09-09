package Program;
import Program.NumberOfLuka;

import java.util.Scanner;

//Визначити, які числа серед перших N чисел Люка є квадратами.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number N: ");
        int n = in.nextInt();
        NumberOfLuka[] arr = new NumberOfLuka[n];
        createArr(n, arr);
        PrintArr(arr);
    }

    /**
     * Метод для створення масиву чисел Люка до N числа
     * @param arr масив об'єктів класу NumberOfLuka
     * @param n порядковий номер останього числа
     */
    public static void createArr(int n, NumberOfLuka [] arr){
        arr[0] = new NumberOfLuka(2);
        arr[1] = new NumberOfLuka(1);
        arr[1].setIsSquare(true);

        for (int i = 2; i<n ;i++){
            arr[i] = new NumberOfLuka(arr[i-2].getValue() + arr[i-1].getValue());
            if (Math.sqrt (arr[i].getValue()) % 1 == 0 ){
                arr[i].setIsSquare(true);
            }
        }
    }
    /**
     * Метод для виведення чисел масиву, які є повними квадратами
     * @param arr масив об'єктів класу NumberOfLuka
     */
    public static void PrintArr(NumberOfLuka [] arr){
        for(var e:arr){
            if(e.getIsSquare()) {
                System.out.println(e);
            }
        }
    }


}
