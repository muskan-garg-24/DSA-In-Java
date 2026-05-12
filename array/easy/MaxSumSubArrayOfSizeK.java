package array.easy;
/*
Problem - Maximum Sum Subarray of Size K

Brute Approach   - Check every subarray
Brute T.C        - O(n*k)
Brute S.C        - O(1)

Optimal Approach - Fixed Sliding Window
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        //System.out.println("Brute: " + maxSumBrute(arr, k));
        System.out.println("Optimal: " + maxSumOptimal(arr, k));
    }

    // Fixed sliding window
    public static int maxSumOptimal(int[] arr, int k) {

        int windowSum = 0;

        // first window
        for (int i = 0; i < k; i++) {

            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // slide window
        for (int right = k; right < arr.length; right++) {

            windowSum += arr[right];
            windowSum -= arr[right - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // Check every subarray
    public static int maxSumBrute(int[] arr, int k) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - k; i++) {

            int sum = 0;

            for (int j = i; j < i + k; j++) {

                sum += arr[j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}