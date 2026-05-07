package story_based.easy;
/*
Problem - Game of Thrones - I
Platform - HackerRank

Brute Approach   - Count frequency for every character separately
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Hashing using frequency array
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class GameOfThrones_I {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(gameOfThronesOptimal(s));
        //System.out.println(gameOfThronesBrute(s));

        sc.close();
    }

    // Palindrome permutation check using frequency array
    public static String gameOfThronesOptimal(String s) {

        int[] freq = new int[26];

        // count frequency
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int oddCount = 0;

        // count odd frequencies
        for (int val : freq) {

            if (val % 2 != 0) {
                oddCount++;
            }
        }

        // palindrome possible only if odd count <= 1
        return oddCount <= 1 ? "YES" : "NO";
    }

    // Count every character frequency separately
    public static String gameOfThronesBrute(String s) {

        int oddCount = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            int count = 0;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == ch) {
                    count++;
                }
            }

            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1 ? "YES" : "NO";
    }
}
