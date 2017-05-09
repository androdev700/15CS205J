/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortanalysis;

import java.util.Scanner;

public class QuickSortAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr;
        System.out.println("Enter size of array");
        int size = scanner.nextInt();
        arr = new int[100000];
        for (int i = 0; i < 100000; ++i)
            arr[i] = (int) (1000 * Math.random());
        //System.out.print("Unsorted");
        //for (int a:arr) {
        //System.out.print(a);
        //}
        long startTime = System.nanoTime();
        sort(arr, 0, size - 1);
        long endTime = System.nanoTime();
        //for (int i=0; i<size; ++i)
        //System.out.print(arr[i]+" ");
        System.out.println("Time in nano seconds " + (endTime - startTime));

    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}