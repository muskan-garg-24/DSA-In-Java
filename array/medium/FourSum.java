/*
Problem - 4Sum (GFG)
Pattern - Two Pointer + Sorting
Asked in: Amazon, Microsoft, Google

Brute   T.C - O(n^4)
        S.C - O(1)

Better  T.C - O(n^3)  (using hashing for 2-sum)
        S.C - O(n)

Optimal T.C - O(n^3)
        S.C - O(1) (excluding output)
*/

package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
public static void main(String[] args) {

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        System.out.println("Optimal: " + fourSumOptimal(nums, target));
        //System.out.println("Better: " + fourSumBetter(nums, target));
        //System.out.println("Brute: " + fourSumBrute(nums, target));
    }

    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {

        Arrays.sort(nums); // sort array
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // skip duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {

                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        left++;
                        right--;

                        // skip duplicates
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                Set<Integer> seen = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    int fourth = target - (nums[i] + nums[j] + nums[k]);

                    if (seen.contains(fourth)) {

                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                    seen.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static List<List<Integer>> fourSumBrute(int[] nums, int target) {

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {

                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
