package hiringproblem;

import java.util.*;

/**
 * Created by andro on 18/04/17.
 */
public class Hiring {

    public static void main(String[] args) {
        int[] person = new int[15];
        for (int i = 0; i < person.length; i++) {
            person[i] = (int) (100 * Math.random());
        }

        System.out.println("Preparing List");
        System.out.println("People \t\t Quality");
        System.out.println("--------------------------");
        for (int i = 0; i < person.length; i++) {
            System.out.println("   " + (i + 1) + " \t\t " + "   " + person[i]);
        }

        System.out.println("Started Hiring...");
        int best = 0;
        Random random = new Random();
        int count = 0;
        Set<Integer> set = new LinkedHashSet<>();
        while (count != 15) {
            int id = random.nextInt(person.length);
            set.add(id);
            count++;
        }
        System.out.println();
        for (Integer i : set) {
            if (person[best] < person[i]) {
                best = i;
                System.out.println("Person hired = " + (best + 1));
            } else {
                System.out.println((best + 1) + " is better than " + (i + 1));
            }
        }
    }
}

