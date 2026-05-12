package string.medium;

/*
Problem - Move Pieces to Obtain a String (LC-2337)

Optimal Approach - Two Pointers + Greedy
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class MovePiecesToObtainString {

    public static void main(String[] args) {

        String start = "_L__R__R_";
        String target = "L______RR";

        System.out.println(canChange(start, target));
    }

    // Two pointers + greedy
    public static boolean canChange(String start, String target) {

        int i = 0;
        int j = 0;

        int n = start.length();

        while (i < n || j < n) {

            // skip '_'
            while (i < n && start.charAt(i) == '_') {

                i++;
            }

            while (j < n && target.charAt(j) == '_') {

                j++;
            }

            // both completed
            if (i == n && j == n) {
                return true;
            }

            // one completed early
            if (i == n || j == n) {
                return false;
            }

            char ch1 = start.charAt(i);
            char ch2 = target.charAt(j);

            // different characters
            if (ch1 != ch2) {
                return false;
            }

            // L cannot move right
            if (ch1 == 'L' && i < j) {
                return false;
            }

            // R cannot move left
            if (ch1 == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}