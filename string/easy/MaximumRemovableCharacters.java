package string.easy;
/*
Problem - Maximum Number of Removable Characters (LC-1898)

Brute Approach   - Try removing 1,2,3... chars each time
Brute T.C        - O(n * m * k)
Brute S.C        - O(n)

Optimal Approach - Binary Search + Two Pointers
Optimal T.C      - O(n log k)
Optimal S.C      - O(n)
*/

public class MaximumRemovableCharacters {

    public static void main(String[] args) {

        String s = "abcacb";
        String p = "ab";

        int[] removable = {3, 1, 0};

        System.out.println(maximumRemovals(s, p, removable));
    }

    public static int maximumRemovals(String s, String p, int[] removable) {

        int left = 0;
        int right = removable.length;

        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isSubsequence(s, p, removable, mid)) {

                ans = mid;
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // Check if p is subsequence after removing mid chars
    public static boolean isSubsequence(String s, String p, int[] removable, int mid) {

        boolean[] removed = new boolean[s.length()];

        // Mark removed indices
        for (int i = 0; i < mid; i++) {
            removed[removable[i]] = true;
        }

        int j = 0;

        // Two pointers
        for (int i = 0; i < s.length() && j < p.length(); i++) {

            if (removed[i]) {
                continue;
            }

            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }

        return j == p.length();
    }
}