package story_based.easy;
/*
Problem - HackerRank in a String!(HackerRank)
Approach: Two Pointer

Brute   T.C - O(n * m)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1)
*/

public class HackerrankInString {

    public static void main(String[] args) {

        String s = "hereiamstackerrank";

        //System.out.println("Brute: " + hackerrankInStringBrute(s));
        System.out.println("Optimal: " + hackerrankInStringOptimal(s));
    }
    
    public static String hackerrankInStringOptimal(String s) {

        String target = "hackerrank";

        int j = 0;

        for (int i = 0; i < s.length(); i++) {

            if (j < target.length() &&
                s.charAt(i) == target.charAt(j)) {

                j++;
            }
        }

        return j == target.length() ? "YES" : "NO";
    }

    public static String hackerrankInStringBrute(String s) {

        String target = "hackerrank";

        return isSubsequence(s, target, 0, 0) ? "YES" : "NO";
    }

    // recursive subsequence check
    public static boolean isSubsequence(String s, String target, int i, int j) {

        if (j == target.length()) return true;

        if (i == s.length()) return false;

        if (s.charAt(i) == target.charAt(j)) {
            return isSubsequence(s, target, i + 1, j + 1);
        }

        return isSubsequence(s, target, i + 1, j);
    }
}
