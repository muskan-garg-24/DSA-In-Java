/* It contains both brute and optimal solutions
Problem - First Unique Character in a String
Pattern - Hashing
Asked in: Amzon, Google, Microsoft

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1) (fixed 26 size array)
*/

package string.easy;

public class FirstUniqueCharacterInString {
  public static void main(String[] args) {

        String s = "leetcode";

        //System.out.println("Brute: " + firstUniqCharBrute(s));
        System.out.println("Optimal: " + firstUniqCharOptimal(s));
    }

    public static int firstUniqCharOptimal(String s) {

        int[] freq = new int[26];

        // count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // find first unique
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqCharBrute(String s) {

        for (int i = 0; i < s.length(); i++) {

            boolean unique = true;

            for (int j = 0; j < s.length(); j++) {

                if (i != j && s.charAt(i) == s.charAt(j)) {
                    unique = false;
                    break;
                }
            }

            if (unique) return i;
        }

        return -1;
    }
}
