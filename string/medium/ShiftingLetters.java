package string.medium;
/*
Problem - Shifting Letters (LC-848)

Brute Approach   - Shift ranges repeatedly
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Suffix Sum
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class ShiftingLetters {

    public static void main(String[] args) {

        String s = "abc";
        int[] shifts = {3,5,9};

        //System.out.println("Brute: " + shiftingLettersBrute(s, shifts));
        System.out.println("Optimal: " + shiftingLettersOptimal(s, shifts));
    }

    // Suffix cumulative shifts
    public static String shiftingLettersOptimal(String s, int[] shifts) {

        char[] arr = s.toCharArray();

        long totalShift = 0;

        // traverse from right
        for (int i = shifts.length - 1; i >= 0; i--) {

            totalShift = (totalShift + shifts[i]) % 26;

            // current shifted character
            arr[i] = (char)(((arr[i] - 'a' + totalShift) % 26) + 'a');
        }

        return new String(arr);
    }

    // Shift every range manually
    public static String shiftingLettersBrute(String s, int[] shifts) {

        char[] arr = s.toCharArray();

        for (int i = 0; i < shifts.length; i++) {

            int shift = shifts[i] % 26;

            // shift 0 to i
            for (int j = 0; j <= i; j++) {

                arr[j] = (char)(((arr[j] - 'a' + shift) % 26) + 'a');
            }
        }

        return new String(arr);
    }
}