/* This code contain both brute and optimal solutions

Problem - Valid Palindrome II (Leet code - 680)
Asked in: Amazon, Google
Brute   T.C - O(n³)
        S.C - O(1)
        
Optimal T.C - O(n)
        S.C - O(n)
*/

package string.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepetatingCharacters {
      public static void main(String[] args) {
      String s = "abcabcbb";
      System.out.println("Optimal: " + longestSubstringOptimal(s));
      //System.out.println("Brute: " + longestSubstringBrute(s));

    }

    public static int longestSubstringOptimal(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
        public static int longestSubstringBrute(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                String sub = s.substring(i, j + 1);

                if (allUnique(sub)) {
                    maxLen = Math.max(maxLen, sub.length());
                }
            }
        }
        return maxLen;
    }

    private static boolean allUnique(String str) {
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}
