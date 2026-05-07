package story_based.easy;
/*
Problem - Strong Password
Platform - HackerRank

Brute Approach   - Traverse string separately for each condition
Brute T.C        - O(4 * n)
Brute S.C        - O(1)

Optimal Approach - Single Traversal + Flag Checking
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class StrongPassword {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        String password = sc.next();

        System.out.println(strongPasswordOptimal(password));

        sc.close();
    }

    // Single traversal to check all conditions
    public static int strongPasswordOptimal(String password) {

        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        String special = "!@#$%^&*()-+";

        // check all conditions in one traversal
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            else if (Character.isLowerCase(ch)) {
                hasLower = true;
            }
            else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            else if (special.indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        int missing = 0;

        if (!hasDigit) missing++;
        if (!hasLower) missing++;
        if (!hasUpper) missing++;
        if (!hasSpecial) missing++;

        // password length should be at least 6
        return Math.max(missing, 6 - password.length());
    }


    // Separate traversal for every condition
    public static int strongPasswordBrute(String password) {

        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        String special = "!@#$%^&*()-+";

        // digit check
        for (int i = 0; i < password.length(); i++) {

            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        // lowercase check
        for (int i = 0; i < password.length(); i++) {

            if (Character.isLowerCase(password.charAt(i))) {
                hasLower = true;
                break;
            }
        }

        // uppercase check
        for (int i = 0; i < password.length(); i++) {

            if (Character.isUpperCase(password.charAt(i))) {
                hasUpper = true;
                break;
            }
        }

        // special character check
        for (int i = 0; i < password.length(); i++) {

            if (special.indexOf(password.charAt(i)) != -1) {
                hasSpecial = true;
                break;
            }
        }

        int missing = 0;

        if (!hasDigit) missing++;
        if (!hasLower) missing++;
        if (!hasUpper) missing++;
        if (!hasSpecial) missing++;

        return Math.max(missing, 6 - password.length());
    }
}