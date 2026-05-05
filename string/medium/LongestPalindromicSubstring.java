/*
Problem - Longest Palindromic Substring (LC-5)
Pattern - Two Pointer (Expand Around Center)
Asked in: Amazon, Microsoft, Google

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n^2)
        S.C - O(1)
*/

package string.medium;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {

        String s = "babad";

        //System.out.println("Brute: " + longestPalindromeBrute(s));
        System.out.println("Optimal: " + longestPalindromeOptimal(s));
    }

    public static String longestPalindromeOptimal(String s) {

        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            // odd length palindrome
            int len1 = expand(s, i, i);

            // even length palindrome
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {

                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }

    public static String longestPalindromeBrute(String s) {

        String res = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                if (isPalindrome(s, i, j)) {

                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }

        return res;
    }

     //helper function to check substring is palindrome 
    private static boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
