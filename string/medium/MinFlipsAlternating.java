package string.medium;
/*
Problem - Minimum Number of Flips to Make Binary String Alternating (LC-1888)

Asked in:
Amazon, Google, Meta

Brute Approach   - Try every rotation manually
Brute T.C        - O(n^2)
Brute S.C        - O(n)

Optimal Approach - Sliding Window + Pattern Matching
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class MinFlipsAlternating {

    public static void main(String[] args) {

        String s = "111000";

        //System.out.println("Brute: " + minFlipsBrute(s));
        System.out.println("Optimal: " + minFlipsOptimal(s));
    }

    // Sliding window on doubled string
    public static int minFlipsOptimal(String s) {

        int n = s.length();

        String doubled = s + s;

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        // build alternating patterns
        for (int i = 0; i < doubled.length(); i++) {

            alt1.append(i % 2 == 0 ? '0' : '1');
            alt2.append(i % 2 == 0 ? '1' : '0');
        }

        int diff1 = 0;
        int diff2 = 0;

        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < doubled.length(); right++) {

            // mismatch count
            if (doubled.charAt(right)!= alt1.charAt(right)) {

                diff1++;
            }

            if (doubled.charAt(right) != alt2.charAt(right)) {

                diff2++;
            }

            // maintain window size n
            if (right - left + 1 > n) {

                if (doubled.charAt(left) != alt1.charAt(left)) {

                    diff1--;
                }

                if (doubled.charAt(left) != alt2.charAt(left)) {

                    diff2--;
                }

                left++;
            }

            // valid rotation window
            if (right - left + 1 == n) {

                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }

    // Try every rotation
    public static int minFlipsBrute(String s) {

        int n = s.length();

        int ans = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {

            // rotate string
            String rotated = s.substring(r) + s.substring(0, r);

            int flip1 = 0;
            int flip2 = 0;

            for (int i = 0; i < n; i++) {

                char expected1 = (i % 2 == 0) ? '0' : '1';
                char expected2 = (i % 2 == 0) ? '1' : '0';

                if (rotated.charAt(i) != expected1) {

                    flip1++;
                }

                if (rotated.charAt(i) != expected2) {

                    flip2++;
                }
            }

            ans = Math.min(ans, Math.min(flip1, flip2));
        }

        return ans;
    }
}