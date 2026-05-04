/* This code contains both brute and optimal solution
Problem - Count of Range Sum (LC-327)
Pattern - Prefix Sum + Merge Sort (Divide & Conquer)
Asked in: Google, Amazon

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n log n)
        S.C - O(n)
*/

package array.hard;

import java.util.Arrays;

public class CountOfRangeSum {
  public static void main(String[] args) {

        int[] nums = {-2,5,-1};
        int lower = -2, upper = 2;

        //System.out.println("Brute: " + countRangeSumBrute(nums, lower, upper));
        System.out.println("Optimal: " + countRangeSumOptimal(nums, lower, upper));
    }

    public static int countRangeSumBrute(int[] nums, int lower, int upper) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            long sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countRangeSumOptimal(int[] nums, int lower, int upper) {

        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private static int mergeSort(long[] arr, int low, int high, int lower, int upper) {

        if (low >= high) return 0;

        int mid = (low + high) / 2;

        int count = mergeSort(arr, low, mid, lower, upper)
                  + mergeSort(arr, mid + 1, high, lower, upper);

        int j = mid + 1, k = mid + 1;

        // count valid pairs
        for (int i = low; i <= mid; i++) {

            while (k <= high && arr[k] - arr[i] < lower) k++;
            while (j <= high && arr[j] - arr[i] <= upper) j++;

            count += (j - k);
        }

        // merge step
        Arrays.sort(arr, low, high + 1);

        return count;
    }
}
