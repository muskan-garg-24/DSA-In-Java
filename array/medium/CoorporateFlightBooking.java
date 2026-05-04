/* This code conntains both brute and optimal solutions
Problem - Corporate Flight Bookings
Pattern - Difference Array + Prefix Sum
Asked in: Amazon

Brute   T.C - O(n * bookings)
        S.C - O(1)

Optimal T.C - O(n + bookings)
        S.C - O(n)
*/

package array.medium;

import java.util.Arrays;

public class CoorporateFlightBooking {
  public static void main(String[] args) {

        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;

        //System.out.println("Brute: " + Arrays.toString(corpFlightBookingsBrute(bookings, n)));
        System.out.println("Optimal: " + Arrays.toString(corpFlightBookingsOptimal(bookings, n)));
    }

    public static int[] corpFlightBookingsOptimal(int[][] bookings, int n) {

        int[] diff = new int[n]; // difference array

        for (int[] b : bookings) {

            int first = b[0] - 1; // convert to 0-based
            int last = b[1] - 1;
            int seats = b[2];

            diff[first] += seats;

            if (last + 1 < n) {
                diff[last + 1] -= seats;
            }
        }

        // build prefix sum
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }

    public static int[] corpFlightBookingsBrute(int[][] bookings, int n) {

        int[] arr = new int[n];

        for (int[] b : bookings) {

            int first = b[0] - 1;
            int last = b[1] - 1;
            int seats = b[2];

            // update full range
            for (int i = first; i <= last; i++) {
                arr[i] += seats;
            }
        }

        return arr;
    }
}
