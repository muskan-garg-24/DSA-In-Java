package string.medium;
/*
Problem - Append Characters to String to Make Subsequence (LC-2486)

Brute Approach   - Generate subsequence manually
Brute T.C        - O(n * m)
Brute S.C        - O(m)

Optimal Approach - Two Pointer Subsequence Matching
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class AppendCharacters {
    public static void main(String[] args) {

        String s = "coaching";
        String t = "coding";

        //System.out.println("Brute: " + appendCharactersBrute(s, t));
        System.out.println("Optimal: " + appendCharactersOptimal(s, t));
    }

    // Match t inside s using two pointers
    public static int appendCharactersOptimal(String s, String t) {

        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {

            // character matched
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }

        // remaining chars in t need append
        return t.length() - j;
    }

    // Build matched subsequence manually
    public static int appendCharactersBrute(String s, String t) {

        String matched = "";

        int j = 0;

        for (int i = 0; i < s.length() && j < t.length(); i++) {

            if (s.charAt(i) == t.charAt(j)) {

                matched += s.charAt(i);
                j++;
            }
        }

        return t.length() - matched.length();
    }
}