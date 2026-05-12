package array.easy;
/*
Problem - Find Pivot Index (LC-724)

Brute Approach   - Calculate left and right sum for every index
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Prefix Sum Idea
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class FindPivotIndex {

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};

        //System.out.println("Brute: " + pivotIndexBrute(nums));
        System.out.println("Optimal: " + pivotIndexOptimal(nums));
    }

    public static int pivotIndexBrute(int[] nums) {

        int n = nums.length;

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

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndexOptimal(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}