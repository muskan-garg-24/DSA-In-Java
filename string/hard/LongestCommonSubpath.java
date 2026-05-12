package string.hard;
/*
Problem - Longest Common Subpath (LC-1923)

Optimal Approach - Binary Search + Double Hashing

T.C  - O(totalLength * log n)
S.C  - O(totalLength)
*/

import java.util.*;

public class LongestCommonSubpath {

    static long mod1 = 1000000007L;
    static long mod2 = 1000000009L;

    static long base1 = 100001;
    static long base2 = 100003;

    public static void main(String[] args) {

        int n = 5;

        int[][] paths = {
            {0, 1, 2, 3, 4},
            {2, 3, 4},
            {4, 0, 1, 2, 3}
        };

        System.out.println(longestCommonSubpath(n, paths));
    }

    public static int longestCommonSubpath(int n, int[][] paths) {

        int left = 0;

        int right = Integer.MAX_VALUE;

        // Minimum path length
        for (int[] path : paths) {
            right = Math.min(right, path.length);
        }

        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (hasCommonPath(paths, mid)) {

                ans = mid;
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // Check if common subpath exists
    public static boolean hasCommonPath(int[][] paths, int len) {

        if (len == 0) {
            return true;
        }

        long power1 = 1;
        long power2 = 1;

        for (int i = 1; i < len; i++) {

            power1 = (power1 * base1) % mod1;
            power2 = (power2 * base2) % mod2;
        }

        HashSet<String> common = new HashSet<>();

        for (int p = 0; p < paths.length; p++) {

            int[] path = paths[p];

            long hash1 = 0;
            long hash2 = 0;

            HashSet<String> current = new HashSet<>();

            // Initial hash
            for (int i = 0; i < len; i++) {

                hash1 = (hash1 * base1 + path[i]) % mod1;

                hash2 = (hash2 * base2 + path[i]) % mod2;
            }

            current.add(hash1 + "#" + hash2);

            // Rolling hash
            for (int i = len; i < path.length; i++) {

                hash1 = (hash1 - path[i - len] * power1 % mod1 + mod1) % mod1;

                hash1 = (hash1 * base1 + path[i]) % mod1;

                hash2 = (hash2 - path[i - len] * power2 % mod2 + mod2) % mod2;

                hash2 = (hash2 * base2 + path[i]) % mod2;

                current.add(hash1 + "#" + hash2);
            }

            // First path
            if (p == 0) {
                common = current;
            }

            // Intersection
            else {

                common.retainAll(current);

                if (common.isEmpty()) {
                    return false;
                }
            }
        }

        return !common.isEmpty();
    }
}