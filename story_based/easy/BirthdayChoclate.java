package story_based.easy;

/*
Problem - Subarray Division (HackerRank - Birthday Chocolate)
Approach : Sliding Window (Fixed Size)

Brute   T.C - O(n * m)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1)
*/

public class BirthdayChoclate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2};
        int d = 3; // target sum
        int m = 2; // subarray size

        int bruteAns = birthdayBrute(arr, d, m);
        int optimalAns = birthdayOptimal(arr, d, m);

        System.out.println("Brute Answer: " + bruteAns);
        System.out.println("Optimal Answer: " + optimalAns);
    }

    public static int birthdayBrute(int[] arr, int d, int m) {
        int n = arr.length;
        int count = 0;

        // try every index
        for (int i = 0; i <= n - m; i++) {
            int sum = 0;

            // sum of next m elements
            for (int j = i; j < i + m; j++) {
                sum += arr[j];
            }

            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    public static int birthdayOptimal(int[] arr, int d, int m) {
        int n = arr.length;
        int count = 0;
        int sum = 0;

        // first window's sum
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        if (sum == d) count++;

        for (int i = m; i < n; i++) {
            sum += arr[i];        // add new element
            sum -= arr[i - m];    // removing old element

            if (sum == d) {
                count++;
            }
        }

        return count;
    }
}