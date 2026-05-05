package string.easy;
/*
Problem - Isomorphic Strings (LC-205)
Pattern - Hashing (Bi-directional mapping)

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1)
*/

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
  public static void main(String[] args) {

        String s = "egg";
        String t = "add";

       // System.out.println("Brute: " + isIsomorphicBrute(s, t));
        System.out.println("Optimal: " + isIsomorphicOptimal(s, t));
    }

    public static boolean isIsomorphicOptimal(String s, String t) {

        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // check mapping consistency
            if (map1[c1] != map2[c2]) return false;

            // store position +1 (avoid default 0 issue)
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }

        return true;
    }

    public static boolean isIsomorphicBrute(String s, String t) {

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // if already mapped
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            }
            else {
                // check reverse mapping manually
                if (map.containsValue(c2)) return false;
                map.put(c1, c2);
            }
        }

        return true;
    }
}
