package string.easy;
/*
Problem - Count Binary Substrings (LC-696)

Brute Approach   - Generate all substrings
Brute T.C        - O(n^3)
Brute S.C        - O(1)

Optimal Approach - Consecutive Group Counting
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class CountBinarySubstrings {

    public static void main(String[] args) {

        String s = "00110011";

       //System.out.println("Brute: " + countBinarySubstringsBrute(s));
        System.out.println("Optimal: " + countBinarySubstringsOptimal(s));
    }

    // Consecutive group counting
    public static int countBinarySubstringsOptimal(String s) {

        int prevGroup = 0;
        int currGroup = 1;

        int count = 0;

        for (int i = 1; i < s.length(); i++) {

            // Same character group
            if (s.charAt(i) == s.charAt(i - 1)) {

                currGroup++;
            }

            // New group started
            else {

                count += Math.min(prevGroup, currGroup);

                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        // Last groups contribution
        count += Math.min(prevGroup, currGroup);

        return count;
    }

    // Generate all substrings
    public static int countBinarySubstringsBrute(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j < s.length(); j++) {

                String sub = s.substring(i, j + 1);

                if (isValid(sub)) {
                    count++;
                }
            }
        }

        return count;
    }

    // Check valid binary substring
    public static boolean isValid(String s) {

        int zero = 0;
        int one = 0;

        int i = 0;

        char first = s.charAt(0);

        // Count first group
        while (i < s.length() && s.charAt(i) == first) {

            if (first == '0') {
                zero++;
            } else {
                one++;
            }

            i++;
        }

        // No second group
        if (i == s.length()) {
            return false;
        }

        char second = s.charAt(i);

        // Same group again
        if (first == second) {
            return false;
        }

        // Count second group
        while (i < s.length() && s.charAt(i) == second) {

            if (second == '0') {
                zero++;
            } else {
                one++;
            }

            i++;
        }

        return i == s.length() && zero == one;
    }
}