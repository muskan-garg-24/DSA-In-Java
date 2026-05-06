package array.hard;
/*
Problem - Maximum Number of Robots Within Budget (LC-2398)
Approach : Sliding Window + Monotonic Deque

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(n)
*/

import java.util.*;

public class MaxRobotsWithinBudget {

    public static void main(String[] args) {

        int[] chargeTimes = {3,6,1,3,4};
        int[] runningCosts = {2,1,3,4,5};
        long budget = 25;

        //System.out.println("Brute: " + maximumRobotsBrute(chargeTimes, runningCosts, budget));
        System.out.println("Optimal: " + maximumRobotsOptimal(chargeTimes, runningCosts, budget));
    }

    public static int maximumRobotsOptimal(int[] chargeTimes, int[] runningCosts, long budget) {

        Deque<Integer> dq = new ArrayDeque<>(); // store indices (max at front)
        long sum = 0; // running cost sum
        int left = 0, maxLen = 0;

        for (int right = 0; right < chargeTimes.length; right++) {

            // maintain decreasing deque for max chargeTime
            while (!dq.isEmpty() && chargeTimes[dq.peekLast()] <= chargeTimes[right]) {
                dq.pollLast();
            }
            dq.offerLast(right);

            sum += runningCosts[right];

            // shrink window if budget exceeded
            while (!dq.isEmpty() &&
                   chargeTimes[dq.peekFirst()] + (right - left + 1) * sum > budget) {

                // remove left if it is max element
                if (dq.peekFirst() == left) dq.pollFirst();

                sum -= runningCosts[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static int maximumRobotsBrute(int[] chargeTimes, int[] runningCosts, long budget) {

        int n = chargeTimes.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int maxCharge = 0;
            long sum = 0;

            for (int j = i; j < n; j++) {

                maxCharge = Math.max(maxCharge, chargeTimes[j]);
                sum += runningCosts[j];

                long cost = maxCharge + (j - i + 1) * sum;

                if (cost <= budget) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break; // no need to extend further
                }
            }
        }

        return maxLen;
    }
}
