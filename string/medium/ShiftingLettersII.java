package string.medium;
/*
Problem - Shifting Letters II (LC-2381)

Brute Approach   - Apply every shift range manually
Brute T.C        - O(n * q)
Brute S.C        - O(1)

Optimal Approach - Difference Array + Prefix Sum
Optimal T.C      - O(n + q)
Optimal S.C      - O(n)

q = number of queries
*/

public class ShiftingLettersII {

    public static void main(String[] args) {

        String s = "abc";

        int[][] shifts = { {0,1,0}, {1,2,1}, {0,2,1} };

        //System.out.println("Brute: " + shiftingLettersBrute(s, shifts));
        System.out.println("Optimal: " + shiftingLettersOptimal(s, shifts));
    }

    // Difference array + prefix sum
    public static String shiftingLettersOptimal(String s, int[][] shifts) {

        int n = s.length();

        int[] diff = new int[n + 1];

        // process range updates
        for (int[] shift : shifts) {

            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            int val = (dir == 1) ? 1 : -1;

            diff[start] += val;

            if (end + 1 < n) {
                diff[end + 1] -= val;
            }
        }

        char[] arr = s.toCharArray();

        int currShift = 0;

        // build final shifts
        for (int i = 0; i < n; i++) {

            currShift += diff[i];

            int newPos = ((arr[i] - 'a' + currShift) % 26 + 26) % 26;

            arr[i] = (char)(newPos + 'a');
        }

        return new String(arr);
    }

    // Apply every range manually
    public static String shiftingLettersBrute(String s, int[][] shifts) {

        char[] arr = s.toCharArray();

        for (int[] shift : shifts) {

            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            for (int i = start; i <= end; i++) {

                if (dir == 1) {

                    arr[i] = (char)(((arr[i] - 'a' + 1) % 26) + 'a');
                }

                else {

                    arr[i] = (char)(((arr[i] - 'a' - 1 + 26) % 26) + 'a');
                }
            }
        }

        return new String(arr);
    }
} 