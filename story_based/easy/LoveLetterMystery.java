package story_based.easy;
/*
Problem - The Love-Letter Mystery(Hackerrank)
Approach: Two pointer

Brute   T.C - O(n)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1)
*/

public class LoveLetterMystery {

    public static void main(String[] args) {

        String s = "abc";

        System.out.println("Brute: " + theLoveLetterMysteryBrute(s));
        System.out.println("Optimal: " + theLoveLetterMysteryOptimal(s));
    }

    public static int theLoveLetterMysteryOptimal(String s) {

        int left = 0;
        int right = s.length() - 1;

        int operations = 0;

        while (left < right) {

            // add character difference
            operations += Math.abs(s.charAt(left) - s.charAt(right));

            left++;
            right--;
        }
        return operations;
    }

    public static int theLoveLetterMysteryBrute(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        int operations = 0;

        while (left < right) {

            // reduce bigger character step by step
            while (arr[left] != arr[right]) {

                if (arr[left] > arr[right]) {
                    arr[left]--;
                } else {
                    arr[right]--;
                }

                operations++;
            }

            left++;
            right--;
        }
        return operations;
    }
}
