package story_based.easy;
/*
Problem - Electronics Shop (HackerRank)
Approach : Two Pointer + Sorting

Brute   T.C - O(n * m)
        S.C - O(1)

Optimal T.C - O(n log n + m log m)  // sorting
        S.C - O(1)
*/

import java.util.*;

public class ElectronicShop {
     public static void main(String[] args) {
        int[] keyboards = {40, 50, 60};
        int[] drives = {5, 8, 12};
        int budget = 60;

        int bruteAns = getMoneySpentBrute(keyboards, drives, budget);
        int optimalAns = getMoneySpentOptimal(keyboards, drives, budget);

        System.out.println("Brute Answer: " + bruteAns);
        System.out.println("Optimal Answer: " + optimalAns);
    }

    public static int getMoneySpentBrute(int[] keyboards, int[] drives, int b) {
        int maxCost = -1;

        for (int k : keyboards) {
            for (int d : drives) {
                int total = k + d;

                if (total <= b && total > maxCost) {
                    maxCost = total;
                }
            }
        }

        return maxCost;
    }

    public static int getMoneySpentOptimal(int[] keyboards, int[] drives, int b) {

        Arrays.sort(keyboards); // ascending
        Arrays.sort(drives);    // ascending

        int i = 0;
        int j = drives.length - 1;
        int maxCost = -1;

        while (i < keyboards.length && j >= 0) {
            int total = keyboards[i] + drives[j];

            if (total > b) {
                j--; // reduce cost
            } else {
                maxCost = Math.max(maxCost, total);
                i++; // try bigger keyboard
            }
        }

        return maxCost;
    }
}