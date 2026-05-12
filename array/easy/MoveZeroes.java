package array.easy;
/*
Problem - Move Zeroes (LC-283)

Asked in:
Amazon, Google, Meta

Brute Approach   - Use extra array
Brute T.C        - O(n)
Brute S.C        - O(n)

Optimal Approach - Two Pointers
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        int[] bruteArr = nums.clone();
        moveZeroesBrute(bruteArr);

        int[] optimalArr = nums.clone();
        moveZeroesOptimal(optimalArr);

        //System.out.println("Brute: " + Arrays.toString(bruteArr));
        System.out.println("Optimal: " + Arrays.toString(optimalArr));
    }

    // Two pointers
    public static void moveZeroesOptimal(int[] nums) {

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // non-zero found
            if (nums[right] != 0) {

                swap(nums, left, right);
                left++;
            }
        }
    }

    // Extra array
    public static void moveZeroesBrute(int[] nums) {

        int[] temp = new int[nums.length];

        int index = 0;

        // store non-zero elements
        for (int num : nums) {

            if (num != 0) {
                temp[index++] = num;
            }
        }

        // copy back
        for (int i = 0;
             i < nums.length;
             i++) {

            nums[i] = temp[i];
        }
    }

    // swap helper
    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}