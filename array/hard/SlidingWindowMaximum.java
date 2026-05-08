package array.hard;
/*
Problem - Sliding Window Maximum (LC-239)

Brute Approach   - Find max for every window
Brute T.C        - O(n * k)
Brute S.C        - O(1)

Optimal Approach - Sliding Window + Monotonic Deque
Optimal T.C      - O(n)
Optimal S.C      - O(k)
*/

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        //System.out.println("Brute: " + Arrays.toString(maxSlidingWindowBrute(nums, k)));
        System.out.println("Optimal: " + Arrays.toString(maxSlidingWindowOptimal(nums, k)));
    }

    // Monotonic decreasing deque
    public static int[] maxSlidingWindowOptimal(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // remove out of window indices
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {

                dq.pollFirst();
            }

            // remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {

                dq.pollLast();
            }

            // add current index
            dq.offerLast(i);

            // window formed
            if (i >= k - 1) {

                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }

    // Find max in every window
    public static int[] maxSlidingWindowBrute(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        int idx = 0;

        for (int i = 0; i <= n - k; i++) {

            int max = nums[i];

            for (int j = i; j < i + k; j++) {

                max = Math.max(max, nums[j]);
            }

            ans[idx++] = max;
        }

        return ans;
    }
}