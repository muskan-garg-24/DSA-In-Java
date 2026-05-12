package string.hard;
/*
Problem - Minimum Time to Revert Word to Initial State II (LC-3031)

Brute Approach   - Simulate every operation
Brute T.C        - O(n^2)
Brute S.C        - O(n)

Optimal Approach - Z Algorithm
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class MinimumTimeToRevertWord {

    public static void main(String[] args) {

        String word = "abacaba";
        int k = 3;

        System.out.println("Optimal: " + minimumTimeToInitialStateOptimal(word, k));
    }

    public static int minimumTimeToInitialStateBrute(String word, int k) {

        int n = word.length();

        int time = 1;

        while (time * k < n) {

            String remaining = word.substring(time * k);

            if (word.startsWith(remaining)) {
                return time;
            }

            time++;
        }

        return time;
    }

    public static int minimumTimeToInitialStateOptimal(String word, int k) {

        int n = word.length();

        int[] z = buildZArray(word);

        for (int i = k; i < n; i += k) {

            // suffix matches prefix
            if (z[i] >= n - i) {
                return i / k;
            }
        }

        return (n + k - 1) / k;
    }

    // Build Z array
    public static int[] buildZArray(String s) {

        int n = s.length();

        int[] z = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {

            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {

                z[i]++;
            }

            if (i + z[i] - 1 > right) {

                left = i;
                right = i + z[i] - 1;
            }
        }

        return z;
    }
}