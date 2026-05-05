package string.easy;
/*
Problem - Backspace String Compare (LC-844)
Pattern - Two Pointer (Reverse Traversal)

Brute   T.C - O(n)
        S.C - O(n)

Optimal T.C - O(n)
        S.C - O(1)
*/

public class BackspaceStringCompare {
  public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";

        //System.out.println("Brute: " + backspaceCompareBrute(s, t));
        System.out.println("Optimal: " + backspaceCompareOptimal(s, t));
    }

    public static boolean backspaceCompareOptimal(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {

            i = getNextValidCharIndex(s, i);
            j = getNextValidCharIndex(t, j);

            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;

            if (s.charAt(i) != t.charAt(j)) return false;

            i--;
            j--;
        }

        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {

        int skip = 0;

        while (index >= 0) {

            if (str.charAt(index) == '#') {
                skip++;
                index--;
            }
            else if (skip > 0) {
                skip--;
                index--;
            }
            else {
                break;
            }
        }

        return index;
    }

    public static boolean backspaceCompareBrute(String s, String t) {

        return build(s).equals(build(t));
    }

    private static String build(String str) {

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {

            if (c == '#') {
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
