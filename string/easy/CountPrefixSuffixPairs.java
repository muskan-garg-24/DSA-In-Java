package string.easy;
/*
Problem - Count Prefix and Suffix Pairs I (LC-3042)

Asked in:
Amazon

Brute Approach   - Check every pair manually
Brute T.C        - O(n^2 * m)
Brute S.C        - O(1)

Optimal Approach - startsWith() + endsWith()
Optimal T.C      - O(n^2 * m)
Optimal S.C      - O(1)

Note:
Constraints are small,
so brute and optimal are nearly same.
*/

public class CountPrefixSuffixPairs {

    public static void main(String[] args) {

        String[] words = {"a", "aba", "ababa", "aa"};

        //System.out.println("Brute: " + countPrefixSuffixPairsBrute(words));
        System.out.println("Optimal: " + countPrefixSuffixPairsOptimal(words));
    }

    // startsWith + endsWith
    public static int countPrefixSuffixPairsOptimal(String[] words) {

        int count = 0;

        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {

                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {

                    count++;
                }
            }
        }

        return count;
    }

    // Manual prefix and suffix checking
    public static int countPrefixSuffixPairsBrute(String[] words) {

        int count = 0;

        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {

                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    // Manual checking
    public static boolean isPrefixAndSuffix(String small, String big) {

        if (small.length() > big.length()) {
            return false;
        }

        int n = small.length();

        // prefix check
        for (int i = 0; i < n; i++) {

            if (small.charAt(i) != big.charAt(i)) {
                return false;
            }
        }

        // suffix check
        int j = big.length() - n;

        for (int i = 0; i < n; i++) {

            if (small.charAt(i) != big.charAt(j + i)) {
                return false;
            }
        }

        return true;
    }
}