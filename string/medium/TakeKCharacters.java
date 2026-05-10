package string.medium;
/*
Problem - Take K of Each Character From Left and Right (LC-2516)

Brute Approach   - Try all left/right combinations
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Sliding Window (Keep Maximum Middle)
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class TakeKCharacters {

    public static void main(String[] args) {

        String s = "aabaaaacaabc";
        int k = 2;

        //System.out.println("Brute: " + takeCharactersBrute(s, k));
        System.out.println("Optimal: " + takeCharactersOptimal(s, k));
    }

    // Keep maximum valid middle window
    public static int takeCharactersOptimal(String s, int k) {

        int n = s.length();

        int[] total = new int[3];

        // total frequencies
        for (char ch : s.toCharArray()) {
            total[ch - 'a']++;
        }

        // impossible case
        if (total[0] < k || total[1] < k || total[2] < k) {

            return -1;
        }

        int left = 0;
        int maxWindow = 0;

        int[] window = new int[3];

        for (int right = 0; right < n; right++) {

            window[s.charAt(right) - 'a']++;

            // invalid window
            while (total[0] - window[0] < k || total[1] - window[1] < k || total[2] - window[2] < k) {

                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }

    // Try every left-right take combination
    public static int takeCharactersBrute(String s, int k) {

        int n = s.length();

        int ans = Integer.MAX_VALUE;

        for (int leftTake = 0; leftTake <= n; leftTake++) {

            int[] freq = new int[3];

            // take from left
            for (int i = 0; i < leftTake; i++) {

                freq[s.charAt(i) - 'a']++;
            }

            // take from right
            for (int rightTake = 0; rightTake + leftTake <= n; rightTake++) {

                if (rightTake > 0) {

                    freq[s.charAt(n - rightTake) - 'a']++;
                }

                // valid selection
                if (freq[0] >= k && freq[1] >= k && freq[2] >= k) {

                    ans = Math.min( ans, leftTake + rightTake);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}