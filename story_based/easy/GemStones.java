package story_based.easy;
/*
Problem - Gemstones
Platform - HackerRank

Brute Approach   - For every character, check in every string using contains()
Brute T.C        - O(26 * n * m)
Brute S.C        - O(1)

Optimal Approach - Hashing using frequency array
Optimal T.C      - O(n * m)
Optimal S.C      - O(1)
*/

import java.util.*;

public class GemStones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println(gemstonesOptimal(arr));
        //System.out.println(gemstonesBrute(arr));

        sc.close();
    }

    // Count characters present in all strings
    public static int gemstonesOptimal(String[] arr) {

        int[] freq = new int[26];

        for (String s : arr) {

            boolean[] seen = new boolean[26];

            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);

                // avoid duplicate counting in same string
                if (!seen[ch - 'a']) {

                    freq[ch - 'a']++;
                    seen[ch - 'a'] = true;
                }
            }
        }

        int count = 0;

        // character present in all strings
        for (int val : freq) {

            if (val == arr.length) {
                count++;
            }
        }

        return count;
    }

    // Check every alphabet in every string
    public static int gemstonesBrute(String[] arr) {

        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            boolean present = true;

            for (String s : arr) {

                if (!s.contains(String.valueOf(ch))) {
                    present = false;
                    break;
                }
            }

            if (present) {
                count++;
            }
        }

        return count;
    }
}
