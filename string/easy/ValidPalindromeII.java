/* This code contain both brute and optimal functions

Problem - Valid Palindrome II (Leet code - 680)
Asked in: Amazon, Google
Brute   T.C - O(n²) to O(n³)
        S.C - O(n)
        
Optimal T.C - O(n)
        S.C - O(1)
*/

package string.easy;

public class ValidPalindromeII {
    public static void main(String[] args) {
      String s = "abca";
      System.out.println(validPalindromeOptimal(s));
      // System.out.println(validPalindromeBrute(s));
    }

    public static boolean validPalindromeOptimal(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return check(s, left + 1, right) || check(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
        public static boolean validPalindromeBrute(String s) {
        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(0, i) + s.substring(i + 1);
            if (isPalindrome(newStr)) return true;
        }
        return isPalindrome(s);
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    } 
}
