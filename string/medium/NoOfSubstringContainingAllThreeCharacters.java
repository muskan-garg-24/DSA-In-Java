package string.medium;
/*
Problem - Number of Substrings Containing All Three Characters (LC-1358)

Brute Approach   - Generate all substrings
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Variable Size Sliding Window + Hashing
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class NoOfSubstringContainingAllThreeCharacters {

    public static void main(String[] args) {

        String s = "abcabc";

        //System.out.println("Brute: " + numberOfSubstringsBrute(s));
        System.out.println("Optimal: " + numberOfSubstringsOptimal(s));
    }

    // Variable sliding window
    public static int numberOfSubstringsOptimal(String s) {

        int[] freq = new int[3];

        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            // add current character
            freq[s.charAt(right) - 'a']++;

            // valid window
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // all larger substrings valid
                count += s.length() - right;

                // shrink window
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }

    // Generate every substring
    public static int numberOfSubstringsBrute(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] freq = new int[3];

            for (int j = i; j < s.length(); j++) {

                freq[s.charAt(j) - 'a']++;

                // valid substring
                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                    ans++;
                }
            }
        }

        return ans;
    }
}