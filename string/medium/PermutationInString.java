package string.medium;
/*
Problem - Permutation in String (LC-567)

Brute Approach   - Generate all permutations and search
Brute T.C        - O(n! * m)
Brute S.C        - O(n!)

Optimal Approach - Sliding Window + Frequency Hashing
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class PermutationInString {
    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

       // System.out.println("Brute: " + checkInclusionBrute(s1, s2));
        System.out.println("Optimal: " + checkInclusionOptimal(s1, s2));
    }

    // Sliding window with frequency arrays
    public static boolean checkInclusionOptimal(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // frequency of s1
        for (int i = 0; i < s1.length(); i++) {

            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // first window match
        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        // slide window
        for (int i = s1.length();
             i < s2.length();
             i++) {

            // add new char
            freq2[s2.charAt(i) - 'a']++;

            // remove old char
            freq2[s2.charAt(i - s1.length()) - 'a']--;

            // compare frequencies
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }

    // Generate all permutations
    public static boolean checkInclusionBrute(String s1, String s2) {

        List<String> perms = new ArrayList<>();

        generatePermutations(s1.toCharArray(), 0, perms);

        for (String str : perms) {

            if (s2.contains(str)) {
                return true;
            }
        }

        return false;
    }

    // permutation generator
    public static void generatePermutations(char[] arr, int idx, List<String> perms) {

        if (idx == arr.length) {

            perms.add(new String(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            swap(arr, idx, i);

            generatePermutations(arr, idx + 1, perms);

            swap(arr, idx, i);
        }
    }

    // swap helper
    public static void swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}