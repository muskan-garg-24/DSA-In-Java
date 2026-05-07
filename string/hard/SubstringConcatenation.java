package string.hard;
/*
Problem - Substring with Concatenation of All Words (LC-30)

Brute Approach   - Generate every substring and compare frequencies
Brute T.C        - O(n * totalWords)
Brute S.C        - O(k)

Optimal Approach - Sliding Window + HashMap
Optimal T.C      - O(n * wordLength)
Optimal S.C      - O(k)

k = number of words
*/

import java.util.*;

public class SubstringConcatenation {

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        //System.out.println("Brute: " + findSubstringBrute(s, words));
        System.out.println("Optimal: " + findSubstringOptimal(s, words));
    }

    // Sliding window word by word
    public static List<Integer> findSubstringOptimal(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return ans;
        }

        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int totalWords = words.length;
        //int windowSize = wordLen * totalWords;

        // start from every offset
        for (int i = 0; i < wordLen; i++) {

            int left = i;
            int count = 0;

            Map<String, Integer> seen = new HashMap<>();

            for (int right = i;
                 right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // valid word
                if (wordMap.containsKey(word)) {

                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // shrink if extra frequency
                    while (seen.get(word) > wordMap.get(word)) {

                        String leftWord =
                                s.substring(left, left + wordLen);

                        seen.put(leftWord,
                                seen.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                    // valid window found
                    if (count == totalWords) {
                        ans.add(left);
                    }
                }

                else {

                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return ans;
    }

    // Check every possible substring
    public static List<Integer> findSubstringBrute(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        for (int i = 0;
             i + totalLen <= s.length();
             i++) {

            Map<String, Integer> seen = new HashMap<>();

            int j = 0;

            while (j < words.length) {

                int start = i + j * wordLen;

                String word =
                        s.substring(start, start + wordLen);

                if (!wordMap.containsKey(word)) {
                    break;
                }

                seen.put(word,
                        seen.getOrDefault(word, 0) + 1);

                if (seen.get(word) > wordMap.get(word)) {
                    break;
                }

                j++;
            }

            if (j == words.length) {
                ans.add(i);
            }
        }

        return ans;
    }
}