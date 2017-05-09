package minmaxproblem;

import java.util.Scanner;

/**
 * Created by andro on 18/04/17.
 */
public class MinMax {

    static class Struct {
        int min, max;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("1. For Static Data\n2. For Random Data");
        int choice;
        choice = s.nextInt();
        int[] arr = {10, 12, 9, 7, 15, 11, 1, 0};
        switch (choice) {
            case 1:
                long startTime = System.nanoTime();
                Struct answer = getMinMax(arr, 0, arr.length - 1);
                long endTime = System.nanoTime();
                System.out.println("Max : " + answer.max + "\nMin : " + answer.min);
                System.out.println("Total time taken in nano seconds = " + (endTime - startTime));
                break;
            case 2:
                System.out.println("Enter Number of Terms");
                int num = s.nextInt();
                int[] rand = new int[num];
                for (int i = 0; i < num; i++) {
                    rand[i] = (int) (100000 * Math.random());
                }
                long startTime1 = System.nanoTime();
                answer = getMinMax(rand, 0, arr.length - 1);
                long endTime1 = System.nanoTime();
                System.out.println("Max : " + answer.max + "\nMin : " + answer.min);
                System.out.println("Total time taken in nano seconds = " + (endTime1 - startTime1));
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
    }

    private static Struct getMinMax(int arr[], int start, int end) {

        Struct result = new Struct();

        if (start >= end) {
            result.max = result.min = arr[start];
            return result;
        }

        Struct temp1, temp2;
        int mid = (start + end) / 2;
        temp1 = getMinMax(arr, start, mid);
        temp2 = getMinMax(arr, mid + 1, end);
        result.min = temp1.min < temp2.min ? temp1.min : temp2.min;
        result.max = temp1.max > temp2.max ? temp1.max : temp2.max;
        return result;
    }
}