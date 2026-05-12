package array.easy;
/*
Problem - Maximum Average Subarray I (LC-643)

Brute Approach   - Check every subarray
Brute T.C        - O(n*k)
Brute S.C        - O(1)

Optimal Approach - Fixed Sliding Window
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class MaxAverageSubarray {

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        //System.out.println("Brute: " + findMaxAverageBrute(nums, k));
        System.out.println("Optimal: " + findMaxAverageOptimal(nums, k));
    }

    // Fixed sliding window
    public static double findMaxAverageOptimal(int[] nums, int k) {

        int windowSum = 0;

        // first window
        for (int i = 0; i < k; i++) {

            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // slide window
        for (int right = k; right < nums.length; right++) {

            windowSum += nums[right];
            windowSum -= nums[right - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    // Check every subarray
    public static double findMaxAverageBrute(int[] nums, int k) {

        double maxAvg = -Double.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {

            int sum = 0;

            for (int j = i; j < i + k; j++) {

                sum += nums[j];
            }

            maxAvg = Math.max(maxAvg, (double) sum / k);
        }

        return maxAvg;
    }
}