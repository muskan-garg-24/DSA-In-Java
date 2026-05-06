package story_based.easy;
/*
Problem - Assign Cookies (LC-455)
Approach : Greedy (Two Pointer)

Brute   T.C - O(n * m)
        S.C - O(n)

Optimal T.C - O(n log n + m log m)
        S.C - O(1)
*/

import java.util.*;

public class AssignCookies {
      public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};

        //System.out.println("Brute: " + findContentChildrenBrute(g, s));
        System.out.println("Optimal: " + findContentChildrenOptimal(g, s));
    }

    public static int findContentChildrenBrute(int[] g, int[] s) {

        boolean[] used = new boolean[s.length];
        int count = 0;

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (!used[j] && s[j] >= g[i]) {
                    used[j] = true;
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static int findContentChildrenOptimal(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }

        return i;
    }
}