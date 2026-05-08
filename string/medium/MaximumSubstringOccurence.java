package string.medium;
/*
Problem - Maximum Number of Occurrences of a Substring (LC-1297)

Brute Approach   - Generate all substrings
Brute T.C        - O(n^3)
Brute S.C        - O(n)

Optimal Approach - Sliding Window + HashMap
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

import java.util.*;

public class MaximumSubstringOccurence {

    public static void main(String[] args) {

        String s = "aababcaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;

        //System.out.println("Brute: " + maxFreqBrute(s, maxLetters, minSize, maxSize));
        System.out.println("Optimal: " + maxFreqOptimal(s, maxLetters, minSize, maxSize));
    }

    // Fixed size sliding window of minSize
    public static int maxFreqOptimal(String s, int maxLetters, int minSize, int maxSize) {

        Map<String, Integer> freqMap = new HashMap<>();

        int[] chars = new int[26];

        int unique = 0;
        int maxFreq = 0;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // add character
            char ch = s.charAt(right);

            if (chars[ch - 'a'] == 0) {
                unique++;
            }

            chars[ch - 'a']++;

            // maintain window size
            if (right - left + 1 > minSize) {

                char leftChar = s.charAt(left);

                chars[leftChar - 'a']--;

                if (chars[leftChar - 'a'] == 0) {
                    unique--;
                }

                left++;
            }

            // valid window
            if (right - left + 1 == minSize && unique <= maxLetters) {

                String sub = s.substring(left, right + 1);

                freqMap.put(sub, freqMap.getOrDefault(sub, 0) + 1);

                maxFreq = Math.max(maxFreq, freqMap.get(sub));
            }
        }

        return maxFreq;
    }

    // Generate every substring
    public static int maxFreqBrute(String s, int maxLetters, int minSize, int maxSize) {

        Map<String, Integer> map = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int len = minSize; len <= maxSize && i + len <= s.length(); len++) {

                String sub = s.substring(i, i + len);

                if (uniqueChars(sub) <= maxLetters) {

                    map.put(sub, map.getOrDefault(sub,0) + 1);

                    ans = Math.max( ans,map.get(sub));
                }
            }
        }

        return ans;
    }

    // count unique characters
    public static int uniqueChars(String s) {

        boolean[] seen = new boolean[26];

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (!seen[ch - 'a']) {

                seen[ch - 'a'] = true;
                count++;
            }
        }

        return count;
    }
}