package string.medium;
/*
Problem - Count Number of Nice Subarrays (LC-1248)

Asked in:
Amazon, Google, Microsoft

Brute Approach   - Generate all subarrays
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Sliding Window + At Most K
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class NiceSubarrays {

    public static void main(String[] args) {

        int[] nums = {1,1,2,1,1};
        int k = 3;

        //System.out.println("Brute: " + numberOfSubarraysBrute(nums, k));
        System.out.println("Optimal: " + numberOfSubarraysOptimal(nums, k));
    }

    // exactly(k) = atMost(k) - atMost(k-1)
    public static int numberOfSubarraysOptimal(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    // count subarrays with at most k odds
    public static int atMost(int[] nums, int k) {

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // odd number found
            if (nums[right] % 2 != 0) {
                k--;
            }

            // shrink window
            while (k < 0) {

                if (nums[left] % 2 != 0) {
                    k++;
                }

                left++;
            }

            // all valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }

    // Generate every subarray
    public static int numberOfSubarraysBrute(int[] nums, int k) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int odd = 0;

            for (int j = i; j < nums.length; j++) {

                // count odd numbers
                if (nums[j] % 2 != 0) {
                    odd++;
                }

                // valid subarray
                if (odd == k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}