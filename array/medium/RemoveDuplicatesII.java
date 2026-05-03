/*
Problem - Remove Duplicates from Sorted Array II (LeetCode - 80)
Pattern - Two Pointer
Asked in: Amazon, Microsoft

Brute   T.C - O(n) 
        S.C - O(n)

Optimal T.C - O(n)
        S.C - O(1)
*/

package array.medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesII {
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,1,2,3,3};

        // Brute (uncomment to run brute approach)
        // int[] copy = nums.clone();
        // int len1 = removeDuplicatesBrute(copy);
        // System.out.println("Brute Length: " + len1);
        // printArray(copy, len1);

        // Optimal
        int len2 = removeDuplicatesOptimal(nums);
        System.out.println("Optimal Length: " + len2);
        printArray(nums, len2);
    }

    public static int removeDuplicatesOptimal(int[] nums) {

        // pointer for placing elements
        int index = 0;

        for (int num : nums) {

            // allow first 2 elements OR if current != element at index-2
            if (index < 2 || num != nums[index - 2]) {
                nums[index] = num;
                index++;
            }
        }

        return index;
    }

    public static int removeDuplicatesBrute(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // count occurrences manually
            int count = 0;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == nums[i]) count++;
            }

            // allow only 2 occurrences
            if (count < 2) {
                list.add(nums[i]);
            }
        }

        // copy back to array
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }

    // helper to print array
    public static void printArray(int[] nums, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
