//Написать программу вычисления n-ого треугольного числа

package hw2;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.print("Введите число n: ");
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt();
        Scanner.close();
        
        if (n <= 0) System.out.print("Некорректное число n: ");
        if (n > 0){
            boolean f = triangle(n);
            if (f) System.out.printf("Число %d является треугольником числа ", n);
            else System.out.printf("Число %d не является треугольником числа ", n);
        }
    }

    public static boolean triangle(int num) {
        int sum = 0;
        for(int i = 1; i <= num; i++){
            sum = sum + i;
            if (sum == num) return true;
       
        }
        return false;
    }
}
