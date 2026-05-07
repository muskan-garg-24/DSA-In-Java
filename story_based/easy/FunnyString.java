package story_based.easy;
/*
Problem - Funny String(HackerRank)
Approach: Two pointer

Brute   T.C - O(n)
        S.C - O(n)

Optimal T.C - O(n)
        S.C - O(1)
*/

public class FunnyString {

    public static void main(String[] args) {

        String s = "acxz";

        //System.out.println("Brute: " + funnyStringBrute(s));
        System.out.println("Optimal: " + funnyStringOptimal(s));
    }

        public static String funnyStringOptimal(String s) {

        int n = s.length();

        for (int i = 1; i < n; i++) {

            int diff1 = Math.abs(s.charAt(i) - s.charAt(i - 1));

            int diff2 = Math.abs(
                    s.charAt(n - i) - s.charAt(n - i - 1)
            );

            if (diff1 != diff2) {
                return "Not Funny";
            }
        }

        return "Funny";
    }
    
        public static String funnyStringBrute(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        for (int i = 1; i < s.length(); i++) {

            int diff1 = Math.abs(s.charAt(i) - s.charAt(i - 1));

            int diff2 = Math.abs(rev.charAt(i) - rev.charAt(i - 1));

            if (diff1 != diff2) {
                return "Not Funny";
            }
        }

        return "Funny";
    }
}