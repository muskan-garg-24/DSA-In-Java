package story_based.easy;
/*
Problem - Beautiful Binary String
Platform - HackerRank

Brute Approach   - Replace "010" repeatedly
Brute T.C        - O(n^2)
Brute S.C        - O(n)

Optimal Approach - Greedy String Traversal
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class BeautifulBinaryString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(beautifulBinaryStringOptimal(s));

        sc.close();
    }

    // Greedy traversal to count occurrences of "010"
    public static int beautifulBinaryStringOptimal(String s) {

        int count = 0;

        for (int i = 0; i < s.length() - 2; i++) {

            // check pattern "010"
            if (s.charAt(i) == '0' &&
                s.charAt(i + 1) == '1' &&
                s.charAt(i + 2) == '0') {

                count++;

                // skip next characters
                i += 2;
            }
        }

        return count;
    }

    // Replace every "010" one by one
    public static int beautifulBinaryStringBrute(String s) {

        int count = 0;

        while (s.contains("010")) {

            int idx = s.indexOf("010");

            // replace last char to break pattern
            s = s.substring(0, idx + 2) + '1' + s.substring(idx + 3);

            count++;
        }

        return count;
    }
}
