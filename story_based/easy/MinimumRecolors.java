package story_based.easy;
/*
Problem - Minimum Recolors to Get K Consecutive Black Blocks (LC-2379)

Brute Approach   - Check every window of size k and count whites
Brute T.C        - O(n * k)
Brute S.C        - O(1)

Optimal Approach - Sliding Window (Fixed Size)
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class MinimumRecolors {

    public static void main(String[] args) {

        String blocks = "WBBWWBBWBW";
        int k = 7;

        System.out.println("Brute: " + minimumRecolorsBrute(blocks, k));
        System.out.println("Optimal: " + minimumRecolorsOptimal(blocks, k));
    }

    // Sliding Window of size k
    public static int minimumRecolorsOptimal(String blocks, int k) {

        int white = 0;

        // first window
        for (int i = 0; i < k; i++) {

            if (blocks.charAt(i) == 'W') {
                white++;
            }
        }

        int min = white;

        // slide window
        for (int i = k; i < blocks.length(); i++) {

            // remove left char
            if (blocks.charAt(i - k) == 'W') {
                white--;
            }

            // add right char
            if (blocks.charAt(i) == 'W') {
                white++;
            }

            min = Math.min(min, white);
        }

        return min;
    }

    // Check every substring of size k
    public static int minimumRecolorsBrute(String blocks, int k) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= blocks.length() - k; i++) {

            int white = 0;

            for (int j = i; j < i + k; j++) {

                if (blocks.charAt(j) == 'W') {
                    white++;
                }
            }

            min = Math.min(min, white);
        }

        return min;
    }
}
