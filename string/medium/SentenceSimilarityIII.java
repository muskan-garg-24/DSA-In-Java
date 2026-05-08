package string.medium;
/*
Problem - Sentence Similarity III (LC-1813)

Brute Approach   - Try removing every middle part
Brute T.C        - O(n^2)
Brute S.C        - O(n)

Optimal Approach - Two Pointer + Prefix/Suffix Matching
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

import java.util.*;

public class SentenceSimilarityIII {

    public static void main(String[] args) {

        String s1 = "My name is Haley";
        String s2 = "My Haley";

        //System.out.println("Brute: " + areSentencesSimilarBrute(s1, s2));
        System.out.println("Optimal: " + areSentencesSimilarOptimal(s1, s2));
    }

    // Match prefix and suffix words
    public static boolean areSentencesSimilarOptimal(String s1, String s2) {

        String[] a = s1.split(" ");
        String[] b = s2.split(" ");

        // ensure a is smaller
        if (a.length > b.length) {
            return areSentencesSimilarOptimal(s2, s1);
        }

        int left = 0;

        // prefix match
        while (left < a.length && a[left].equals(b[left])) {

            left++;
        }

        int right = 0;

        // suffix match
        while (right < a.length - left && a[a.length - 1 - right].equals(b[b.length - 1 - right])) {
           
            right++;
        }

        return left + right == a.length;
    }

    // Remove every possible middle part
    public static boolean areSentencesSimilarBrute(String s1, String s2) {

        String[] a = s1.split(" ");
        String[] b = s2.split(" ");

        // ensure a is smaller
        if (a.length > b.length) {
            return areSentencesSimilarBrute(s2, s1);
        }

        for (int start = 0; start <= b.length; start++) {

            for (int end = start; end <= b.length; end++) {

                List<String> temp = new ArrayList<>();

                for (int i = 0; i < b.length; i++) {

                    if (i < start || i >= end) {
                        temp.add(b[i]);
                    }
                }

                if (Arrays.equals(a, temp.toArray(new String[0]))) {
                    return true;
                }
            }
        }
        return false;
    }
}
