package string.easy;
/*
Problem - Count Prefixes of a Given String (LC-2255)

Asked in:
Amazon

Brute Approach   - Manual prefix checking
Brute T.C        - O(n * m)
Brute S.C        - O(1)

Optimal Approach - startsWith()
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class CountPrefixes {

    public static void main(String[] args) {

        String[] words = {"a", "b", "c", "ab", "bc", "abc"};
        String s = "abc";

        //System.out.println("Brute: " + countPrefixesBrute(words, s));
        System.out.println("Optimal: " + countPrefixesOptimal(words, s));
    }

    // startsWith()
    public static int countPrefixesOptimal(String[] words, String s) {

        int count = 0;

        for (String word : words) {

            if (s.startsWith(word)) {
                count++;
            }
        }

        return count;
    }

    // Manual prefix checking
    public static int countPrefixesBrute(String[] words, String s) {

        int count = 0;

        for (String word : words) {

            if (isPrefix(word, s)) {
                count++;
            }
        }

        return count;
    }

    // Manual prefix check
    public static boolean isPrefix(String word, String s) {

        if (word.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}