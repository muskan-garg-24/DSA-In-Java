/* This code contains both brute and optimal solutions
Problem - Reverse Words in a String III
Pattern - Two Pointer (String)
Asked in: Amazon, Microsoft

Brute   T.C - O(n)
        S.C - O(n)

Optimal T.C - O(n)
        S.C - O(1) (ignoring output string)
*/

package string.easy;

public class ReverseWordInStringIII {
  public static void main(String[] args) {

        String s = "Let's take LeetCode contest";

        System.out.println("Brute: " + reverseWordsBrute(s));
        System.out.println("Optimal: " + reverseWordsOptimal(s));
    }

    public static String reverseWordsOptimal(String s) {

        char[] arr = s.toCharArray(); // convert to char array
        int start = 0;

        for (int end = 0; end <= arr.length; end++) {

            // when we reach space or end of string
            if (end == arr.length || arr[end] == ' ') {

                reverse(arr, start, end - 1); // reverse current word
                start = end + 1;
            }
        }

        return new String(arr);
    }

    // helper function to reverse characters
    private static void reverse(char[] arr, int left, int right) {

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static String reverseWordsBrute(String s) {

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {

            StringBuilder temp = new StringBuilder(word);
            result.append(temp.reverse().toString()).append(" ");
        }

        return result.toString().trim();
    }
}
