package string.medium;
/*
Problem - Check if a String Contains All Binary Codes of Size K (LC-1461)

Brute Approach   - Generate all binary strings and search
Brute T.C        - O(2^k * n)
Brute S.C        - O(2^k)

Optimal Approach - Sliding Window + HashSet
Optimal T.C      - O(n * k)
Optimal S.C      - O(2^k)
*/

import java.util.*;

public class BinaryCodes {

    public static void main(String[] args) {

        String s = "00110110";
        int k = 2;

        //System.out.println("Brute: " + hasAllCodesBrute(s, k));
        System.out.println("Optimal: " + hasAllCodesOptimal(s, k));
    }

    // Sliding Window + HashSet
    public static boolean hasAllCodesOptimal(String s, int k) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {

            String sub = s.substring(i, i + k);
            set.add(sub);
        }

        return set.size() == (1 << k);
    }

    // Generate every binary string and search
    public static boolean hasAllCodesBrute(String s, int k) {

        int total = 1 << k;

        for (int num = 0; num < total; num++) {

            String binary = Integer.toBinaryString(num);

            // Add leading zeros
            while (binary.length() < k) {
                binary = "0" + binary;
            }

            if (!s.contains(binary)) {
                return false;
            }
        }

        return true;
    }
}
