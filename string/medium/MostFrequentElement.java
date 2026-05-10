package string.medium;
/*
Problem - Frequency of the Most Frequent Element (LC-1838)

Brute Approach   - Try every target frequency
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Sorting + Sliding Window
Optimal T.C      - O(n log n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class MostFrequentElement {

    public static void main(String[] args) {

        int[] nums = {1,2,4};
        int k = 5;

        //System.out.println("Brute: " + maxFrequencyBrute(nums, k));
        System.out.println("Optimal: " + maxFrequencyOptimal(nums, k));
    }

    // Sorting + sliding window
    public static int maxFrequencyOptimal(int[] nums, int k) {

        Arrays.sort(nums);

        long windowSum = 0;

        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {

            windowSum += nums[right];

            // operations needed
            while ((long) nums[right] * (right - left + 1) - windowSum > k) {

                windowSum -= nums[left];
                left++;
            }

            maxFreq = Math.max( maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    // Try every target element
    public static int maxFrequencyBrute(int[] nums, int k) {

        Arrays.sort(nums);

        int ans = 1;

        for (int i = 0; i < nums.length; i++) {

            long operations = 0;

            int count = 1;

            for (int j = i - 1; j >= 0; j--) {

                operations += nums[i] - nums[j];

                if (operations <= k) {
                    count++;
                }
                else {
                    break;
                }
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}