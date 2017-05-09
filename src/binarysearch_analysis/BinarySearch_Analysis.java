/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch_analysis;

import java.util.Scanner;

/**
 * @author ayushsingh
 */
public class BinarySearch_Analysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] arr;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter size");
        int size = s.nextInt();
        arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + i);
            arr[i] = s.nextInt();
        }

        System.out.println("Enter element to be searched");
        int search = s.nextInt();

        int beg = 0;
        int end = size - 1;
        int mid = (beg + end) / 2;

        long startTime = System.nanoTime();

        while (beg <= end) {

            if (arr[mid] < search) {
                beg = mid + 1;

            } else if (arr[mid] > search) {
                end = mid - 1;

            } else if (arr[mid] == search) {
                System.out.println("Element found at index " + mid);
                break;
            }
            mid = (beg + end) / 2;
        }

        if (beg > end) {
            System.out.println("Element  not found.");
        }

        long endTime = System.nanoTime();
        System.out.println("Execution time in nano seconds = " + (endTime - startTime));

    }

}
