/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author andro
 */
public class Knapsack {

    public static void main(String args[]) throws IOException {
        int i, j = 0, maxQuantity, m, n;
        float sum = 0, max;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of items");
        n = sc.nextInt();
        int array[][] = new int[2][n];
        System.out.println("Enter the weights and values");
        for (i = 0; i < n; i++) {
            System.out.println("Enter in pair with a space");
            array[0][i] = sc.nextInt();
            array[1][i] = sc.nextInt();
        }
        System.out.println("Enter maximum volume");
        maxQuantity = sc.nextInt();

        m = maxQuantity;
        while (m >= 0) {
            max = 0;
            for (i = 0; i < n; i++) {
                if (((float) array[1][i]) / ((float) array[0][i]) > max) {
                    max = ((float) array[1][i]) / ((float) array[0][i]);
                    j = i;
                }
            }
            if (array[0][j] > m) {
                System.out.println("Quantity of item number : " + (j + 1) + " added is " + m);
                sum += m * max;
                m = -1;
            } else {
                System.out.println("Quantity of item number : " + (j + 1) + " added is " + array[0][j]);
                m -= array[0][j];
                sum += (float) array[1][j];
                array[1][j] = 0;
            }
        }
        System.out.println("Max Benifit = " + sum);
    }
}