/* This code contains brute, better and optimal solution.
Problem - Subarrays with K Distinct Integers
Pattern - Sliding Window + Hashing
Platform: LeetCode
Asked in: Google, Amazon

Brute   T.C - O(n^3)
        S.C - O(n)

Better  T.C - O(n^2)
        S.C - O(n)

Optimal T.C - O(n)
        S.C - O(n)
*/

package array.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarrayWithKDistnictIntegers {
  public static void main(String[] args) {

        int[] nums = {1,2,1,2,3};
        int k = 2;

        System.out.println("Brute: " + subarraysWithKDistinctBrute(nums, k));
        //System.out.println("Better: " + subarraysWithKDistinctBetter(nums, k));
        //System.out.println("Optimal: " + subarraysWithKDistinctOptimal(nums, k));
    }

    // Exact K = AtMost(K) - AtMost(K-1)
    public static int subarraysWithKDistinctOptimal(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {

        if (k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // add element to window
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // shrink window if distinct > k
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            // count subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }

    
    // Using set to track distinct elements
    public static int subarraysWithKDistinctBetter(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> set = new HashSet<>();

            for (int j = i; j < nums.length; j++) {

                set.add(nums[j]);

                if (set.size() == k) count++;
                else if (set.size() > k) break;
            }
        }

        return count;
    }

    // Generate all subarrays and check distinct manually
    public static int subarraysWithKDistinctBrute(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                if (isValid(nums, i, j, k)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValid(int[] nums, int l, int r, int k) {

        Set<Integer> set = new HashSet<>();

        for (int i = l; i <= r; i++) {
            set.add(nums[i]);
        }

        return set.size() == k;
    }
}
