package string.easy;
/*
Problem - Find Smallest Letter Greater Than Target (LC-744)

Brute Approach   - Linear search
Brute T.C        - O(n)
Brute S.C        - O(1)

Optimal Approach - Binary Search
Optimal T.C      - O(log n)
Optimal S.C      - O(1)
*/

public class SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {

        char[] letters = {'c', 'f', 'j'};
        char target = 'a';

        //System.out.println("Brute: " + nextGreatestLetterBrute(letters, target));
        System.out.println("Optimal: " + nextGreatestLetterOptimal(letters, target));
    }

    public static char nextGreatestLetterBrute(char[] letters, char target) {

        for (char ch : letters) {

            if (ch > target) {
                return ch;
            }
        }

        // Wrap around
        return letters[0];
    }

    public static char nextGreatestLetterOptimal(char[] letters, char target) {

        int left = 0;
        int right = letters.length - 1;

        char ans = letters[0];

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {

                ans = letters[mid];
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        return ans;
    }
}