package string.easy;
/*
Problem - Is Subsequence (LC-392)

Brute Approach   - Generate all subsequences
Brute T.C        - O(2^n)
Brute S.C        - O(2^n)

Optimal Approach - Two Pointers
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class IsSubsequence {

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        //System.out.println("Brute: " + isSubsequenceBrute(s, t));
        System.out.println("Optimal: " + isSubsequenceOptimal(s, t));
    }

    // Two pointers
    public static boolean isSubsequenceOptimal(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() &&
               j < t.length()) {

            // character matched
            if (s.charAt(i)
                == t.charAt(j)) {

                i++;
            }

            j++;
        }

        return i == s.length();
    }

    // Generate all subsequences
    public static boolean isSubsequenceBrute(String s, String t) {

        List<String> list = new ArrayList<>();

        generateSubsequence(t, 0, "", list);

        return list.contains(s);
    }

    // recursion helper
    public static void generateSubsequence(String t, int index, String curr, List<String> list) {

        if (index == t.length()) {

            list.add(curr);
            return;
        }

        // take character
        generateSubsequence(t, index + 1, curr + t.charAt(index), list);

        // skip character
        generateSubsequence(t, index + 1, curr, list);
    }
}