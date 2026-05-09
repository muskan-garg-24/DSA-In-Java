package string.medium;
/*
Problem - Longest Semi-Repetitive Substring (LC-2730)

Brute Approach   - Check every substring
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Variable Size Sliding Window
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class LongestSemiRepetativeSubstring {

    public static void main(String[] args) {

        String s = "52233";

        //System.out.println("Brute: " + longestSemiRepetitiveSubstringBrute(s));
        System.out.println("Optimal: " + longestSemiRepetitiveSubstringOptimal(s));
    }

    // Sliding window with repeated pair count
    public static int longestSemiRepetitiveSubstringOptimal(String s) {

        int left = 0;
        int pairs = 0;
        int maxLen = 1;

        for (int right = 1; right < s.length(); right++) {

            // found adjacent equal pair
            if (s.charAt(right) == s.charAt(right - 1)) {

                pairs++;
            }

            // shrink if more than one pair
            while (pairs > 1) {

                if (s.charAt(left) == s.charAt(left + 1)) {

                    pairs--;
                }

                left++;
            }

            maxLen = Math.max( maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Check every substring
    public static int longestSemiRepetitiveSubstringBrute(String s) {

        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {

            int pairs = 0;

            for (int j = i + 1; j < s.length(); j++) {

                // count repeated pairs
                if (s.charAt(j) == s.charAt(j - 1)) {

                    pairs++;
                }

                // valid substring
                if (pairs <= 1) {

                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else {
                    break;
                }
            }
        }

        return maxLen;
    }
}