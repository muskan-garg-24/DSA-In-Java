package string.easy;
/*
Problem - Pangrams
Platform - HackerRank

Brute Approach   - For every alphabet, search entire string
Brute T.C        - O(26 * n)
Brute S.C        - O(1)

Optimal Approach - Hashing using boolean array
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class Pangrams {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(pangramsOptimal(s));

        sc.close();
    }

    // Use boolean array to mark characters
    public static String pangramsOptimal(String s) {

        boolean[] seen = new boolean[26];

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // check lowercase letters
            if (ch >= 'a' && ch <= 'z') {
                seen[ch - 'a'] = true;
            }
        }

        // check all alphabets present
        for (boolean val : seen) {

            if (!val) {
                return "not pangram";
            }
        }

        return "pangram";
    }

    // Search every alphabet separately
    public static String pangramsBrute(String s) {

        s = s.toLowerCase();

        for (char ch = 'a'; ch <= 'z'; ch++) {

            boolean found = false;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return "not pangram";
            }
        }

        return "pangram";
    }
}