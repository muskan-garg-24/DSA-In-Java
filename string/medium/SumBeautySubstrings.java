package string.medium;
/*
Problem - Sum of Beauty of All Substrings (LC-1781)

Brute Approach   - Generate substring + recount freq
Brute T.C        - O(n^3)
Brute S.C        - O(1)

Optimal Approach - Hashing + Incremental Frequency
Optimal T.C      - O(n^2)
Optimal S.C      - O(1)
*/

public class SumBeautySubstrings {

    public static void main(String[] args) {

        String s = "aabcb";

        //System.out.println("Brute: " + beautySumBrute(s));
        System.out.println("Optimal: " +  beautySumOptimal(s));
    }

    // Expand substring while updating frequency
    public static int beautySumOptimal(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] freq = new int[26];

            for (int j = i; j < s.length(); j++) {

                // add current character
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                // calculate max/min frequency
                for (int val : freq) {

                    if (val > 0) {

                        maxFreq = Math.max(maxFreq, val);
                        minFreq = Math.min(minFreq, val);
                    }
                }

                ans += maxFreq - minFreq;
            }
        }

        return ans;
    }

    // Recalculate frequencies for every substring
    public static int beautySumBrute(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                int[] freq = new int[26];

                // rebuild substring frequency
                for (int k = i; k <= j; k++) {

                    freq[s.charAt(k) - 'a']++;
                }

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int val : freq) {

                    if (val > 0) {

                        maxFreq = Math.max(maxFreq, val);
                        minFreq = Math.min(minFreq, val);
                    }
                }

                ans += maxFreq - minFreq;
            }
        }

        return ans;
    }
}