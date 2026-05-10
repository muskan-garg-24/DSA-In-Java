package string.medium;
/*
Problem - Product of Array Except Self (LC-238)

Brute Approach   - Calculate product for every index separately
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Prefix Product + Suffix Product
Optimal T.C      - O(n)
Optimal S.C      - O(1) excluding output array
*/

import java.util.*;

public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        //System.out.println("Brute: " + Arrays.toString(productExceptSelfBrute(nums)));
        System.out.println("Optimal: " + Arrays.toString(productExceptSelfOptimal(nums)));
    }

    // Prefix + Suffix Product
    public static int[] productExceptSelfOptimal(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        // Store prefix products
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Multiply suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }

    // Calculate product except self manually
    public static int[] productExceptSelfBrute(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int product = 1;

            for (int j = 0; j < n; j++) {

                if (i != j) {
                    product *= nums[j];
                }
            }

            ans[i] = product;
        }

        return ans;
    }
}