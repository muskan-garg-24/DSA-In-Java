package string.medium;
/*
Problem - Get Equal Substrings Within Budget (LC-1208)

Asked in:
Amazon, Google

Brute Approach   - Check every substring cost
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Variable Size Sliding Window
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class EqualSubstringBudget {

    public static void main(String[] args) {

        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;

        //System.out.println("Brute: " + equalSubstringBrute(s, t, maxCost));
        System.out.println("Optimal: " + equalSubstringOptimal(s, t, maxCost));
    }

    // Sliding window with running cost
    public static int equalSubstringOptimal(String s, String t, int maxCost) {

        int left = 0;
        int cost = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // add current conversion cost
            cost += Math.abs( s.charAt(right) - t.charAt(right));

            // shrink window if over budget
            while (cost > maxCost) {

                cost -= Math.abs( s.charAt(left) - t.charAt(left));

                left++;
            }

            maxLen = Math.max( maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Check every substring
    public static int equalSubstringBrute(String s, String t, int maxCost) {

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            int cost = 0;

            for (int j = i; j < s.length(); j++) {

                cost += Math.abs(s.charAt(j) - t.charAt(j));

                if (cost <= maxCost) {

                    maxLen = Math.max( maxLen, j - i + 1);
                }
                else {
                    break;
                }
            }
        }
        return maxLen;
    }
}