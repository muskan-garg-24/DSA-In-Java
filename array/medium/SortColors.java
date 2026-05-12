package array.medium;
/*
Problem - Sort Colors (LC-75)

Brute Approach   - Use built-in sorting
Brute T.C        - O(n log n)
Brute S.C        - Depends on sort

Optimal Approach - Dutch National Flag Algorithm
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class SortColors {

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        int[] bruteArr = nums.clone();
        sortColorsBrute(bruteArr);

        int[] optimalArr = nums.clone();
        sortColorsOptimal(optimalArr);

        //System.out.println("Brute: " + Arrays.toString(bruteArr));
        System.out.println("Optimal: " + Arrays.toString(optimalArr));
    }

    // Dutch National Flag Algorithm
    public static void sortColorsOptimal(int[] nums) {

        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while (mid <= right) {

            // 0 -> move left
            if (nums[mid] == 0) {

                swap(nums, left, mid);
                left++;
                mid++;
            }

            // 1 -> already correct
            else if (nums[mid] == 1) {

                mid++;
            }

            // 2 -> move right
            else {

                swap(nums, mid, right);
                right--;
            }
        }
    }

    // Built-in sorting
    public static void sortColorsBrute(int[] nums) {

        Arrays.sort(nums);
    }

    // swap helper
    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}