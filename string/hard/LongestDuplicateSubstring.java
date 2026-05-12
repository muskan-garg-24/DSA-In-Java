package string.hard;
/*
Problem - Longest Duplicate Substring (LC-1044)

Brute Approach   - Check all substrings
Brute T.C        - O(n^3)
Brute S.C        - O(n)

Optimal Approach - Binary Search + Rolling Hash
Optimal T.C      - O(n log n)
Optimal S.C      - O(n)
*/

import java.util.*;

public class LongestDuplicateSubstring {

    public static void main(String[] args) {

        String s = "banana";

        //System.out.println("Brute: " + longestDupSubstringBrute(s));
        System.out.println("Optimal: " + longestDupSubstringOptimal(s));
    }

    public static String longestDupSubstringBrute(String s) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String sub = s.substring(i, j);

                if (sub.length() > ans.length() &&
                    s.indexOf(sub, i + 1) != -1) {

                    ans = sub;
                }
            }
        }

        return ans;
    }

    public static String longestDupSubstringOptimal(String s) {

        int left = 1;
        int right = s.length() - 1;

        String ans = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            String found = search(s, mid);

            if (!found.equals("")) {

                ans = found;
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // Rolling hash search
    public static String search(String s, int len) {

        long mod = (1L << 31) - 1;
        long base = 256;

        long hash = 0;
        long power = 1;

        HashSet<Long> seen = new HashSet<>();

        // Initial hash
        for (int i = 0; i < len; i++) {

            hash = (hash * base + s.charAt(i)) % mod;

            if (i > 0) {
                power = (power * base) % mod;
            }
        }

        seen.add(hash);

        // Sliding window hash
        for (int i = len; i < s.length(); i++) {

            hash = (hash - s.charAt(i - len) * power % mod + mod) % mod;

            hash = (hash * base + s.charAt(i)) % mod;

            if (seen.contains(hash)) {

                return s.substring(i - len + 1, i + 1);
            }

            seen.add(hash);
        }

        return "";
    }
}