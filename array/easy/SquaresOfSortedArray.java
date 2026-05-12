package array.easy;
/*
Problem - Squares of a Sorted Array (LC-977)

Brute Approach   - Square then sort
Brute T.C        - O(n log n)
Brute S.C        - O(1)

Optimal Approach - Two Pointers
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

import java.util.*;

public class SquaresOfSortedArray {

    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};

        //System.out.println("Brute: " + Arrays.toString(sortedSquaresBrute(nums)));
        System.out.println("Optimal: " + Arrays.toString(sortedSquaresOptimal(nums)));
    }

    // Two pointers
    public static int[] sortedSquaresOptimal(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;

        int index = n - 1;

        while (left <= right) {

            int leftSquare = nums[left] * nums[left];

            int rightSquare = nums[right] * nums[right];

            // place bigger square
            if (leftSquare > rightSquare) {

                ans[index] = leftSquare;
                left++;
            }

            else {

                ans[index] = rightSquare;
                right--;
            }

            index--;
        }

        return ans;
    }

    // Square then sort
    public static int[] sortedSquaresBrute(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            ans[i] = nums[i] * nums[i];
        }

        Arrays.sort(ans);

        return ans;
    }
}
