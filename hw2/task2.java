//Написать программу, показывающую последовательность действий для игры “Ханойская башня” 
//Разобрать решение, осознать.
package hw2;

public class task2 {
    public static void main(String args[]){
        int n = 4;
        towerOfHanoi(n, "Исходный", "Конечный", "Буфферный"); 
    
    }
    static void towerOfHanoi(int n, String start, String end, String buffer){

        if (n == 1){
            System.out.println("Перемещаем диск 1 со стержня " +  start + " на стержень " + end);
            return;
        }
        towerOfHanoi(n-1, start, buffer, end);
        System.out.println("Перемещаем диск " + n + " со стержня " +  start + " на стержень " + end);
        towerOfHanoi(n-1, buffer, end, start);
    }   
}
