package string.medium;
/*
Problem - Count Vowel Strings in Ranges (LC-2559)

Brute Approach   - Check every query range
Brute T.C        - O(q * n)
Brute S.C        - O(1)

Optimal Approach - Prefix Sum
Optimal T.C      - O(n + q)
Optimal S.C      - O(n)
*/

import java.util.*;

public class CountVowelStringsInRanges {

    public static void main(String[] args) {

        String[] words = {"aba", "bcb", "ece", "aa", "e"};

        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};

        //System.out.println("Brute: " + Arrays.toString(vowelStringsBrute(words, queries)));
        System.out.println("Optimal: " + Arrays.toString(vowelStringsOptimal(words, queries)));
    }

    // Prefix Sum
    public static int[] vowelStringsOptimal(String[] words, int[][] queries) {

        int n = words.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {

            prefix[i + 1] = prefix[i];

            if (isVowelString(words[i])) {
                prefix[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            ans[i] = prefix[right + 1] - prefix[left];
        }

        return ans;
    }

    // Check every query range
    public static int[] vowelStringsBrute(String[] words, int[][] queries) {

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            int count = 0;

            for (int j = left; j <= right; j++) {

                if (isVowelString(words[j])) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }

    // Check starts and ends with vowel
    public static boolean isVowelString(String word) {

        char first = Character.toLowerCase(word.charAt(0));
        char last = Character.toLowerCase(word.charAt(word.length() - 1));

        return isVowel(first) && isVowel(last);
    }

    // Vowel checker
    public static boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}