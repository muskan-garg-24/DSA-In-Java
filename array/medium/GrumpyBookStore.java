package array.medium;
/*
Problem - Grumpy Bookstore Owner (LC-1052)
Approach : Sliding window (fixed size)

Brute   T.C - O(n * minutes)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1)
*/

public class GrumpyBookStore {

    public static void main(String[] args) {

        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy =    {0,1,0,1,0,1,0,1};
        int minutes = 3;

        //System.out.println("Brute: " + maxSatisfiedBrute(customers, grumpy, minutes));
        System.out.println("Optimal: " + maxSatisfiedOptimal(customers, grumpy, minutes));
    }

    public static int maxSatisfiedOptimal(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;

        int alreadySatisfied = 0;

        // count already satisfied
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                alreadySatisfied += customers[i];
            }
        }

        // sliding window for extra gain
        int extra = 0, maxExtra = 0;

        for (int i = 0; i < n; i++) {

            if (grumpy[i] == 1) {
                extra += customers[i];
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }

            maxExtra = Math.max(maxExtra, extra);
        }

        return alreadySatisfied + maxExtra;
    }

    public static int maxSatisfiedBrute(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;
        int max = 0;

        for (int i = 0; i <= n - minutes; i++) {

            int total = 0;

            for (int j = 0; j < n; j++) {

                if (grumpy[j] == 0 || (j >= i && j < i + minutes)) {
                    total += customers[j];
                }
            }

            max = Math.max(max, total);
        }

        return max;
    }
}