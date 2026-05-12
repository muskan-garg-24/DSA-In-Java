package array.medium;
/*
Problem - 3Sum Closest (LC-16)

Brute Approach   - Check all triplets
Brute T.C        - O(n^3)
Brute S.C        - O(1)

Optimal Approach - Sorting + Two Pointers
Optimal T.C      - O(n^2)
Optimal S.C      - O(1)
*/

import java.util.*;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        //System.out.println("Brute: " + threeSumClosestBrute(nums, target));
        System.out.println("Optimal: " + threeSumClosestOptimal(nums, target));
    }

    // Sorting + two pointers
    public static int threeSumClosestOptimal(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // update closest sum
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {

                    closestSum = sum;
                }

                // move pointers
                if (sum < target) {

                    left++;
                }

                else if (sum > target) {

                    right--;
                }

                else {

                    return sum;
                }
            }
        }

        return closestSum;
    }

    // Check all triplets
    public static int threeSumClosestBrute(int[] nums, int target) {

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {

                        closestSum = sum;
                    }
                }
            }
        }

        return closestSum;
    }
}