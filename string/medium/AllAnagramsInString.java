package string.medium;
/*
Problem - Find All Anagrams in a String (LC-438)
Pattern - Sliding Window + Hashing

Brute   T.C - O(n * m log m)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1)
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramsInString {
  public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        //System.out.println("Brute: " + findAnagramsBrute(s, p));
        System.out.println("Optimal: " + findAnagramsOptimal(s, p));
    }

    public static List<Integer> findAnagramsOptimal(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] freq = new int[26];

        // build freq for pattern
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {

            // include current char
            if (freq[s.charAt(right) - 'a'] > 0) {
                count--;
            }
            freq[s.charAt(right) - 'a']--;
            right++;

            // window size match
            if (count == 0) {
                result.add(left);
            }

            // maintain window size
            if (right - left == p.length()) {

                if (freq[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }

                freq[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return result;
    }

    public static List<Integer> findAnagramsBrute(String s, String p) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= s.length() - p.length(); i++) {

            String sub = s.substring(i, i + p.length());

            char[] a = sub.toCharArray();
            char[] b = p.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            if (Arrays.equals(a, b)) {
                res.add(i);
            }
        }

        return res;
    } 
}
