/* This code contains both brute and optimal solutions
Problem - 3Sum (LeetCode - 15, GFG)
Pattern - Two Pointer
Asked in: Amazon, Microsoft

Brute   T.C - O(n^3)
        S.C - O(1)

Optimal T.C - O(n^2)
        S.C - O(1)
*/

package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
  public static void main(String[] args) {
      int[] nums = {-1,0,1,2,-1,-4};

      System.out.println("Optimal: " + threeSumOptimal(nums));
      //System.out.println("Brute: " + threeSumBrute(nums));
    }

    public static List<List<Integer>> threeSumOptimal(int[] nums) {

        Arrays.sort(nums); // sort array
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSumBrute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);

                        if (!res.contains(temp)) res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}
