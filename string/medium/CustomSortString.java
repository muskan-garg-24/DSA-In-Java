package string.medium;
/*
Problem - Custom Sort String (LC-791)

Brute Approach   - Repeated searching and building
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Hashing / Frequency Array
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class CustomSortString {

    public static void main(String[] args) {

        String order = "cba";
        String s = "abcd";

        //System.out.println("Brute: " + customSortStringBrute(order, s));
        System.out.println("Optimal: " + customSortStringOptimal(order, s));
    }

    // Frequency counting
    public static String customSortStringOptimal(String order, String s) {

        int[] freq = new int[26];

        // count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        // place according to custom order
        for (char ch : order.toCharArray()) {

            while (freq[ch - 'a'] > 0) {

                ans.append(ch);
                freq[ch - 'a']--;
            }
        }

        // append remaining characters
        for (int i = 0; i < 26; i++) {

            while (freq[i] > 0) {

                ans.append((char)(i + 'a'));
                freq[i]--;
            }
        }

        return ans.toString();
    }

    // Repeated searching
    public static String customSortStringBrute(String order, String s) {

        StringBuilder ans = new StringBuilder();

        boolean[] used = new boolean[s.length()];

        // place characters according to order
        for (char ch : order.toCharArray()) {

            for (int i = 0; i < s.length(); i++) {

                if (!used[i] && s.charAt(i) == ch) {

                    ans.append(ch);
                    used[i] = true;
                }
            }
        }

        // append remaining characters
        for (int i = 0; i < s.length(); i++) {

            if (!used[i]) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}