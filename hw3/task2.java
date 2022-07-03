package hw3;

//Реализовать алгоритм пирамидальной сортировки (HeapSort)


import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class task2
{
    public static void main(String args[])
    {   
        System.out.print("Введите размерность массива: ");
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt();
        Scanner.close();

        int arr[] = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) arr[i] = random.nextInt();
        System.out.println("Исходный массив: \n");  
        System.out.print(Arrays.toString(arr));

        sort(arr);

        System.out.println("\nОтсортированный массив: \n"); 
        System.out.print(Arrays.toString(arr));
    }

    public static void sort(int arr[])
    {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);

        for (int i = arr.length - 1; i >= 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i)
    {
        int maxInd = i; 
        int leftInd = 2*i + 1; 
        int rightInd = 2*i + 2; 

        if (leftInd < n && arr[leftInd] > arr[maxInd]) maxInd = leftInd;
        if (rightInd < n && arr[rightInd] > arr[maxInd]) maxInd = rightInd;

        if (maxInd != i)
        {
            int swap = arr[i];
            arr[i] = arr[maxInd];
            arr[maxInd] = swap;
            heapify(arr, n, maxInd);
        }
    }

    public static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}