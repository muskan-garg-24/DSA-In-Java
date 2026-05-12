package array.medium;
/*
Problem - Two Sum II (LC-167)

Brute Approach   - Check every pair
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Two Pointers
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class TwoSumII {

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        //System.out.println("Brute: " + Arrays.toString( twoSumBrute(numbers, target)));
        System.out.println("Optimal: " + Arrays.toString(twoSumOptimal(numbers, target)));
    }

    // Two pointers
    public static int[] twoSumOptimal(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {

                return new int[]{left + 1, right + 1};
            }

            else if (sum < target) {

                left++;
            }

            else {

                right--;
            }
        }

        return new int[]{-1, -1};
    }

    // Check every pair
    public static int[] twoSumBrute(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length;j++) {

                if (numbers[i] + numbers[j]== target) {

                    return new int[]{ i + 1,j + 1 };
                }
            }
        }

        return new int[]{-1, -1};
    }
}