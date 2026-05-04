/* This code conatins both brute and optimal solutions
Problem - Car Pooling (LeetCode - 1094)
Pattern - Difference Array + Prefix Sum
Asked in: Uber

Brute   T.C - O(n * range)
        S.C - O(range)

Optimal T.C - O(n + range)
        S.C - O(range)
*/

package array.medium;

public class CarPooling {
  public static void main(String[] args) {

        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 4;

        //System.out.println("Brute: " + carPoolingBrute(trips, capacity));
        System.out.println("Optimal: " + carPoolingOptimal(trips, capacity));
    }

    public static boolean carPoolingOptimal(int[][] trips, int capacity) {

        int[] diff = new int[1001]; // max range constraint

        // mark changes
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += passengers;  // pickup
            diff[to] -= passengers;    // drop
        }

        int current = 0;

        // build prefix sum
        for (int i = 0; i < diff.length; i++) {
            current += diff[i];

            // check capacity
            if (current > capacity) return false;
        }

        return true;
    }

    public static boolean carPoolingBrute(int[][] trips, int capacity) {

        int[] arr = new int[1001];

        // simulate each trip
        for (int[] trip : trips) {

            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            for (int i = from; i < to; i++) {
                arr[i] += passengers;

                if (arr[i] > capacity) return false;
            }
        }

        return true;
    }
}
