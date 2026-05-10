package string.medium;
/* 
Problem - Longest Continuous Subarray With Absolute Diff <= Limit (LC-1438)

Asked in:
Google, Amazon, Meta

Brute Approach   - Check every subarray
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Sliding Window + Monotonic Deque
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/
import java.util.Deque;
import java.util.LinkedList;

public class LongestSubarrayLimit {
  public static void main(String[] args) {

        int[] nums = {8,2,4,7};
        int limit = 4;

        //System.out.println("Brute: " + longestSubarrayBrute(nums, limit));
        System.out.println("Optimal: " + longestSubarrayOptimal(nums, limit));
    }

    // Sliding window + monotonic deques
    public static int longestSubarrayOptimal(int[] nums, int limit) {

        Deque<Integer> maxDQ = new LinkedList<>();
        Deque<Integer> minDQ = new LinkedList<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            // maintain decreasing deque
            while (!maxDQ.isEmpty() && nums[maxDQ.peekLast()] < nums[right]) {

                maxDQ.pollLast();
            }

            maxDQ.offerLast(right);

            // maintain increasing deque
            while (!minDQ.isEmpty() && nums[minDQ.peekLast()] > nums[right]) {

                minDQ.pollLast();
            }

            minDQ.offerLast(right);

            // invalid window
            while (nums[maxDQ.peekFirst()] - nums[minDQ.peekFirst()] > limit) {

                // remove out of window
                if (maxDQ.peekFirst() == left) {
                    maxDQ.pollFirst();
                }

                if (minDQ.peekFirst() == left) { minDQ.pollFirst();
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Check every subarray
    public static int longestSubarrayBrute(int[] nums, int limit) {

        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            int min = nums[i];
            int max = nums[i];

            for (int j = i; j < nums.length; j++) {

                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if (max - min <= limit) {

                    maxLen = Math.max( maxLen,  j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
