/*
Problem - Longest Subarray with Sum = K
Pattern - Hashing + PrefixSum
Platform: GeeksforGeeks
Asked in: Amazon

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(n)
*/

package array.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println("Optimal: " + longestSubarrayOptimal(arr, k));
    }

    public static int longestSubarrayOptimal(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // if sum == k
            if (sum == k) {
                maxLen = i + 1;
            }

            // if (sum - k) seen before
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            // store only first occurrence
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
    public static int longestSubarrayBrute(int[] arr, int k) {

        int maxLen = 0;

        // generate all subarrays
        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
