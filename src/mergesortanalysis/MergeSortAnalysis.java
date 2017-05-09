/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortanalysis;

import java.util.Scanner;

/**
 * @author ayushsingh
 */
public class MergeSortAnalysis {

    private static void print(int[] arr) {

        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter Size of Array");
        int size = s.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter Elements of Array");
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("Unsorted Array -- >> ");
        print(arr);
        long startTime = System.nanoTime();
        sort(arr, 0, size - 1);
        long endTime = System.nanoTime();
        System.out.println("Sorted Array -- >> ");
        print(arr);
        System.out.println("Time in nano seconds used -- >> " + (endTime - startTime));
    }
}