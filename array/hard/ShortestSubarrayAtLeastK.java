package array.hard;
/*
Problem - Shortest Subarray with Sum at Least K (LC-862)

Brute Approach   - Check all subarrays
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Prefix Sum + Monotonic Deque
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

import java.util.*;

public class ShortestSubarrayAtLeastK {

    public static void main(String[] args) {

        int[] nums = {2, -1, 2};
        int k = 3;

        //System.out.println("Brute: " + shortestSubarrayBrute(nums, k));
        System.out.println("Optimal: " + shortestSubarrayOptimal(nums, k));
    }

    // Prefix sum + monotonic deque
    public static int shortestSubarrayOptimal(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        // build prefix sum
        for (int i = 0; i < n; i++) {

            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new LinkedList<>();

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            // valid subarray found
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {

                minLen = Math.min( minLen, i - dq.pollFirst());
            }

            // maintain increasing prefix sums
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {

                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    // Check every subarray
    public static int shortestSubarrayBrute(int[] nums, int k) {

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            long sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                if (sum >= k) {

                    minLen = Math.min( minLen,  j - i + 1);

                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}