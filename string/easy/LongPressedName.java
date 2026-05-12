package string.easy;
/*
Problem - Long Pressed Name (LC-925)

Brute Approach   - Build groups and compare
Brute T.C        - O(n)
Brute S.C        - O(n)

Optimal Approach - Two Pointers
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class LongPressedName {

    public static void main(String[] args) {

        String name = "alex";
        String typed = "aaleex";

        //System.out.println("Brute: " + isLongPressedNameBrute(name, typed));
        System.out.println("Optimal: " + isLongPressedNameOptimal(name, typed));
    }

    // Two pointers
    public static boolean isLongPressedNameOptimal(String name, String typed) {

        int i = 0;
        int j = 0;

        while (j < typed.length()) {

            // characters match
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {

                i++;
                j++;
            }

            // long pressed character
            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {

                j++;
            }

            else {

                return false;
            }
        }

        return i == name.length();
    }

    // Frequency groups comparison
    public static boolean isLongPressedNameBrute(String name, String typed) {

        List<String> group1 = buildGroups(name);
        List<String> group2 = buildGroups(typed);

        if (group1.size() != group2.size()) {

            return false;
        }

        for (int i = 0; i < group1.size(); i++) {

            char ch1 = group1.get(i).charAt(0);

            char ch2 = group2.get(i).charAt(0);

            if (ch1 != ch2 || group1.get(i).length() > group2.get(i).length()) {

                return false;
            }
        }

        return true;
    }

    // build character groups
    public static List<String> buildGroups(String s) {

        List<String> groups = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            StringBuilder curr = new StringBuilder();

            char ch = s.charAt(i);

            while (i < s.length() && s.charAt(i) == ch) {

                curr.append(ch);
                i++;
            }

            groups.add(curr.toString());
        }

        return groups;
    }
}