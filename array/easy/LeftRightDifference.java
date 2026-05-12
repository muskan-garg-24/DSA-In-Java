package array.easy;
/*
Problem - Left and Right Sum Differences (LC-2574)

Brute Approach   - Calculate left and right sums for every index
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Prefix Sum Idea
Optimal T.C      - O(n)
Optimal S.C      - O(1) (excluding answer array)
*/

import java.util.*;

public class LeftRightDifference {

    public static void main(String[] args) {

        int[] nums = {10, 4, 8, 3};

        //System.out.println("Brute: " + Arrays.toString(leftRightDifferenceBrute(nums)));
        System.out.println("Optimal: " + Arrays.toString(leftRightDifferenceOptimal(nums)));
    }

    public static int[] leftRightDifferenceBrute(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int leftSum = 0;
            int rightSum = 0;

            // Left sum
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            // Right sum
            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }

            ans[i] = Math.abs(leftSum - rightSum);
        }

        return ans;
    }

    public static int[] leftRightDifferenceOptimal(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            ans[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return ans;
    }
}