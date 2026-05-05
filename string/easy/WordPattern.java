package string.easy;
/*
Problem - Word Pattern (LC-290)
Pattern - Hashing (Bi-directional mapping)

Brute   T.C - O(n^2)
        S.C - O(n)

Optimal T.C - O(n)
        S.C - O(n)
*/

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
  public static void main(String[] args) {

        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println("Brute: " + wordPatternBrute(pattern, s));
        System.out.println("Optimal: " + wordPatternOptimal(pattern, s));
    }

    public static boolean wordPatternOptimal(String pattern, String s) {

        String[] words = s.split(" ");

        // length mismatch
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverse = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            // forward mapping
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) return false;
            } else {
                map.put(c, word);
            }

            // reverse mapping
            if (reverse.containsKey(word)) {
                if (reverse.get(word) != c) return false;
            } else {
                reverse.put(word, c);
            }
        }

        return true;
    }

    public static boolean wordPatternBrute(String pattern, String s) {

        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {

            for (int j = i + 1; j < pattern.length(); j++) {

                // same pattern char → same word
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    if (!words[i].equals(words[j])) return false;
                }

                // different pattern char → different word
                if (pattern.charAt(i) != pattern.charAt(j)) {
                    if (words[i].equals(words[j])) return false;
                }
            }
        }

        return true;
    }
}
