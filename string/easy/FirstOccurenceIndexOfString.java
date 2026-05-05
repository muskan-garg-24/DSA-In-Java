package string.easy;
/*
Problem - Find the Index of First Occurrence (LC-28)
Pattern - Two Pointer

Brute   T.C - O(n * m)
        S.C - O(1)

Optimal T.C - O(n * m) (simple approach)
        S.C - O(1)

*/

public class FirstOccurenceIndexOfString {
  public static void main(String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";

        //System.out.println("Brute: " + strStrBrute(haystack, needle));
        System.out.println("Optimal: " + strStrOptimal(haystack, needle));
    }

    public static int strStrOptimal(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) return i;
        }

        return -1;
    }

    public static int strStrBrute(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {

            String sub = "";

            for (int j = i; j < haystack.length(); j++) {
                sub += haystack.charAt(j);

                if (sub.equals(needle)) return i;
            }
        }

        return -1;
    }
}
