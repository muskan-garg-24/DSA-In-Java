package string.medium;
/*
Problem - Number of Matching Subsequences (LC-792)

Brute Approach   - Check every word using two pointers
Brute T.C        - O(words * n)
Brute S.C        - O(1)

Optimal Approach - HashMap + Binary Search
Optimal T.C      - O(n + totalWordsLength * log n)
Optimal S.C      - O(n)
*/

import java.util.*;

public class NumberOfMatchingSubsequences {

    public static void main(String[] args) {

        String s = "abcde";

        String[] words = { "a", "bb", "acd", "ace" };

        //System.out.println("Brute: " + numMatchingSubseqBrute(s, words));
        System.out.println("Optimal: " + numMatchingSubseqOptimal(s, words));
    }

    public static int numMatchingSubseqBrute(String s, String[] words) {

        int count = 0;

        for (String word : words) {

            if (isSubsequence(s, word)) {
                count++;
            }
        }

        return count;
    }

    // Two pointers subsequence check
    public static boolean isSubsequence(String s, String word) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < word.length()) {

            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }

            i++;
        }

        return j == word.length();
    }

    public static int numMatchingSubseqOptimal(String s, String[] words) {

        Map<Character, List<Integer>> map =
                new HashMap<>();

        // Store indices of every character
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            map.putIfAbsent(ch, new ArrayList<>());

            map.get(ch).add(i);
        }

        int count = 0;

        for (String word : words) {

            if (isSubsequenceOptimal(word, map)) {
                count++;
            }
        }

        return count;
    }

    // Binary search on indices
    public static boolean isSubsequenceOptimal(String word, Map<Character, List<Integer>> map) {

        int prevIndex = -1;

        for (char ch : word.toCharArray()) {

            if (!map.containsKey(ch)) {
                return false;
            }

            List<Integer> list = map.get(ch);

            int nextIndex = upperBound(list, prevIndex);

            if (nextIndex == -1) {
                return false;
            }

            prevIndex = nextIndex;
        }

        return true;
    }

    // Find next greater index
    public static int upperBound(List<Integer> list, int target) {

        int left = 0;
        int right = list.size() - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid) > target) {

                ans = list.get(mid);
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        return ans;
    }
}