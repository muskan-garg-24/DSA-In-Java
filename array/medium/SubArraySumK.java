/* This code conatins both brute and optimal solution
Problem - Subarray Sum Equals K (LeetCode - 560, GFG)
Pattern - Hashing + Prefix Sum
Asked in: Google, Facebook
Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(n)
*/

package array.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
  public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;

        System.out.println("Optimal: " + subarraySumOptimal(nums, k));
        //System.out.println("Brute: " + subarraySumBrute(nums, k));
    }
    
    public static int subarraySumOptimal(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            // check if (sum - k) exists
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // store prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int subarraySumBrute(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) count++;
            }
        }
        return count;
    }
}
