package string.medium;
/*
Problem - Camelcase Matching (LC-1023)

Brute Approach   - Build filtered uppercase+matched string
Brute T.C        - O(n * m)
Brute S.C        - O(m)

Optimal Approach - Two Pointer String Matching
Optimal T.C      - O(n * m)
Optimal S.C      - O(1)

n = number of queries
m = average query length
*/

import java.util.*;

public class CamelcaseMatching {

    public static void main(String[] args) {

        String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";

        //System.out.println("Brute: " + camelMatchBrute(queries, pattern));
        System.out.println("Optimal: " + camelMatchOptimal(queries, pattern));
    }

    public static List<Boolean> camelMatchOptimal(String[] queries, String pattern) {

        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {

            int i = 0; // query pointer
            int j = 0; // pattern pointer

            boolean valid = true;

            while (i < query.length()) {

                char q = query.charAt(i);

                // character matched
                if (j < pattern.length() && q == pattern.charAt(j)) {

                    i++;
                    j++;
                }

                // extra lowercase allowed
                else if (Character.isLowerCase(q)) {
                    i++;
                }

                // extra uppercase invalid
                else {
                    valid = false;
                    break;
                }
            }

            // all pattern chars should match
            ans.add(valid && j == pattern.length());
        }

        return ans;
    }

    // Build matching sequence and compare
    public static List<Boolean> camelMatchBrute(String[] queries, String pattern) {

        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {

            String built = "";

            int j = 0;

            boolean valid = true;

            for (int i = 0; i < query.length(); i++) {

                char ch = query.charAt(i);

                // matched char
                if (j < pattern.length() && ch == pattern.charAt(j)) {

                    built += ch;
                    j++;
                }

                // uppercase mismatch invalid
                else if (Character.isUpperCase(ch)) {
                    valid = false;
                    break;
                }
            }

            ans.add(valid && built.equals(pattern));
        }
        return ans;
    }
} 