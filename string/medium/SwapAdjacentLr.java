package string.medium;
/*
Problem - Swap Adjacent in LR String (LC-777)

Brute Approach   - Simulate all swaps
Brute T.C        - O(n^2)
Brute S.C        - O(n)

Optimal Approach - Two Pointer + Greedy
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class SwapAdjacentLr {
    public static void main(String[] args) {

        String start = "RXXLRXRXL";
        String end   = "XRLXXRRLX";

        //System.out.println("Brute: " + canTransformBrute(start, end));
        System.out.println("Optimal: " + canTransformOptimal(start, end));
    }

    // Compare non-X characters using two pointers
    public static boolean canTransformOptimal(String start, String end) {

        int i = 0;
        int j = 0;

        int n = start.length();

        while (i < n || j < n) {

            // skip X in start
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }

            // skip X in end
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }

            // both finished
            if (i == n && j == n) {
                return true;
            }

            // one finished early
            if (i == n || j == n) {
                return false;
            }

            char c1 = start.charAt(i);
            char c2 = end.charAt(j);

            // different chars
            if (c1 != c2) {
                return false;
            }

            // L cannot move right
            if (c1 == 'L' && i < j) {
                return false;
            }

            // R cannot move left
            if (c1 == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

    // Simulate transformations repeatedly
    public static boolean canTransformBrute(String start, String end) {

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {

            String curr = q.poll();

            if (curr.equals(end)) {
                return true;
            }

            for (int i = 0; i < curr.length() - 1; i++) {

                String next = curr;

                // XL -> LX
                if (curr.substring(i, i + 2).equals("XL")) {

                  next = curr.substring(0, i) + "LX" + curr.substring(i + 2);
                }

                // RX -> XR
                else if (curr.substring(i, i + 2).equals("RX")) {

                    next = curr.substring(0, i) + "XR" + curr.substring(i + 2);
                }

                if (!visited.contains(next)) {

                    visited.add(next);
                    q.offer(next);
                }
            }
        }

        return false;
    }
}