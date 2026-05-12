package array.easy;
/*
Problem - Merge Sorted Array (LC-88)

Brute Approach   - Copy + sort
Brute T.C        - O((m+n) log(m+n))
Brute S.C        - O(1)

Optimal Approach - Two Pointers from Back
Optimal T.C      - O(m+n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;

        int[] nums2 = {2,5,6};
        int n = 3;

        int[] bruteArr = nums1.clone();
        mergeBrute(bruteArr, m, nums2, n);

        int[] optimalArr = nums1.clone();
        mergeOptimal(optimalArr, m, nums2, n);

        //System.out.println("Brute: " + Arrays.toString(bruteArr));
        System.out.println("Optimal: " + Arrays.toString(optimalArr));
    }

    // Two pointers from back
    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];
                i--;
            }

            else {

                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // remaining nums2 elements
        while (j >= 0) {

            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    // Copy then sort
    public static void mergeBrute(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {

            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}