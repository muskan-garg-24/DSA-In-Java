package string.easy;
/*
Problem - Check If One String Swap Can Make Strings Equal (LC-1790)

Brute Approach   - Try every possible swap
Brute T.C        - O(n^3)
Brute S.C        - O(n)

Optimal Approach - Greedy Mismatch Checking
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class OneSwapEqual {

    public static void main(String[] args) {

        String s1 = "bank";
        String s2 = "kanb";

        System.out.println("Brute: " + areAlmostEqualBrute(s1, s2));

        System.out.println("Optimal: " + areAlmostEqualOptimal(s1, s2));
    }

    // Check mismatch positions
    public static boolean areAlmostEqualOptimal(String s1, String s2) {

        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i)
                != s2.charAt(i)) {

                diff.add(i);
            }
        }

        // already equal
        if (diff.size() == 0) {
            return true;
        }

        // must have exactly 2 mismatches
        if (diff.size() != 2) {
            return false;
        }

        int i = diff.get(0);
        int j = diff.get(1);

        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }

    // Try every possible swap
    public static boolean areAlmostEqualBrute(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        char[] arr = s1.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                swap(arr, i, j);

                if (new String(arr).equals(s2)) {
                    return true;
                }

                // backtrack
                swap(arr, i, j);
            }
        }

        return false;
    }

    // swap characters
    public static void swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}