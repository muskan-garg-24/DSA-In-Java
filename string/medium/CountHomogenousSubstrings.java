package string.medium;
/*
Problem - Count Homogenous Substrings (LC-1759)
Pattern - Prefix Counting + Consecutive grouping

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1)
*/
public class CountHomogenousSubstrings {
  public static void main(String[] args) {

        String s = "abbcccaa";

        //System.out.println("Brute: " + countHomogenousBrute(s));
        System.out.println("Optimal: " + countHomogenousOptimal(s));
    }

    public static int countHomogenousOptimal(String s) {

        long count = 0;
        long len = 1;

        int mod = 1000000007;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                len++; // same group
            } else {
                count += (len * (len + 1)) / 2;
                len = 1;
            }
        }

        // last group
        count += (len * (len + 1)) / 2;

        return (int)(count % mod);
    }

    public static int countHomogenousBrute(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                if (isHomogenous(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isHomogenous(String s, int l, int r) {

        char c = s.charAt(l);

        for (int i = l; i <= r; i++) {
            if (s.charAt(i) != c) return false;
        }

        return true;
    }
}
