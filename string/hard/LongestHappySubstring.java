package string.hard;
/*
Problem - Longest Happy Prefix (LC-1392)

Brute Approach   - Compare all prefix/suffix pairs
Brute T.C        - O(n^2)
Brute S.C        - O(n)

Optimal Approach - KMP Prefix Function (LPS Array)
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/
public class LongestHappySubstring {
  public static void main(String[] args) {

        String s = "level";

        //System.out.println("Brute: " + longestPrefixBrute(s));
        System.out.println("Optimal: " + longestPrefixOptimal(s));
    }

    // KMP LPS array
    public static String longestPrefixOptimal(String s) {

        int n = s.length();

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {

            // matched character
            if (s.charAt(i) == s.charAt(len)) {

                len++;
                lps[i] = len;
                i++;
            }

            // mismatch
            else {

                if (len != 0) {

                    len = lps[len - 1];
                }
                else {

                    lps[i] = 0;
                    i++;
                }
            }
        }

        // last LPS value = answer length
        return s.substring(0, lps[n - 1]);
    }

    // Check every prefix/suffix
    public static String longestPrefixBrute(String s) {

        for (int len = s.length() - 1; len > 0; len--) {

            String prefix = s.substring(0, len);
            String suffix = s.substring(s.length() - len);

            if (prefix.equals(suffix)) {
                return prefix;
            }
        }

        return "";
    }
}
