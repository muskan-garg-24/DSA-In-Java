package string.hard;
/*
Problem - Minimum Number of Moves to Make Palindrome

Approach - Greedy + Two Pointers
T.C      - O(n^2)
S.C      - O(1)
*/

public class MinMovesPalindrome {

    public static void main(String[] args) {

        String s = "aabb";

        System.out.println("Minimum Moves: " + minMovesToMakePalindrome(s));
    }

    // Greedy + adjacent swapping
    public static int minMovesToMakePalindrome(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        int moves = 0;

        while (left < right) {

            int l = left;
            int r = right;

            // find matching char from right
            while (l < r && arr[l] != arr[r]) {

                r--;
            }

            // unique middle character
            if (l == r) {

                swap(arr, r, r + 1);
                moves++;
            }

            else {

                // bring matching char to right
                while (r < right) {

                    swap(arr, r, r + 1);
                    moves++;
                    r++;
                }

                left++;
                right--;
            }
        }

        return moves;
    }

    // adjacent swap
    public static void swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
