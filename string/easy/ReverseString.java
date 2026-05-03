/* This code contain both brute and optimal functions

Problem -  Reverse String (Leet code - 344)
Asked in: Google, Facebook
Pattern - Two Pointer
Brute   T.C - O(n)
        S.C - O(n)
        
Optimal T.C - O(n)
        S.C - O(1)
*/

package string.easy;

public class ReverseString {
  public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseOptimal(s);
        // char[] res = reverseBrute(s);
        // System.out.println(res);     

        for (char c : s) System.out.print(c);
    }
    public static void reverseOptimal(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
      public static char[] reverseBrute(char[] s) {
      char[] res = new char[s.length];

      for (int i = 0; i < s.length; i++) {
        res[i] = s[s.length - 1 - i];
      }
      return res;
    }
}
