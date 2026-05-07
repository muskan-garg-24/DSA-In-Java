package story_based.easy;
/*
Problem - Mars Exploration
Platform - HackerRank

Brute Approach   - Build expected SOS string then compare
Brute T.C        - O(n)
Brute S.C        - O(n)

Optimal Approach - String Traversal + Pattern Matching
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class MarsExploration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(marsExplorationOptimal(s));

        sc.close();
    }

    // Compare characters directly with repeating SOS pattern
    public static int marsExplorationOptimal(String s) {

        int changes = 0;

        for (int i = 0; i < s.length(); i++) {

            // expected character based on index
            char expected;

            if (i % 3 == 1) {
                expected = 'O';
            } else {
                expected = 'S';
            }

            // mismatch found
            if (s.charAt(i) != expected) {
                changes++;
            }
        }

        return changes;
    }

    // Create original SOS signal then compare
    public static int marsExplorationBrute(String s) {

        String expected = "";

        // build SOS pattern
        for (int i = 0; i < s.length() / 3; i++) {
            expected += "SOS";
        }

        int changes = 0;

        // compare both strings
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != expected.charAt(i)) {
                changes++;
            }
        }

        return changes;
    }
}
