package string.medium;
/*
Problem - Push Dominoes (LC-838)

Brute Approach   - Simulate every second
Brute T.C        - O(n^2)
Brute S.C        - O(n)

Optimal Approach - Two Pointers / Force Segments
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class PushDominoes {

    public static void main(String[] args) {

        String dominoes = ".L.R...LR..L..";
        //System.out.println("Brute: " + pushDominoesBrute(dominoes));
        System.out.println("Optimal: " + pushDominoesOptimal(dominoes));
    }

    // Process force segments
    public static String pushDominoesOptimal(String dominoes) {

        String s = "L" + dominoes + "R";

        StringBuilder ans = new StringBuilder();

        int left = 0;

        for (int right = 1; right < s.length(); right++) {

            // skip dots
            if (s.charAt(right) == '.') {
                continue;
            }

            int middle = right - left - 1;

            // avoid adding imaginary left boundary
            if (left > 0) {
                ans.append(s.charAt(left));
            }

            // same forces
            if (s.charAt(left) == s.charAt(right)) {

                for (int i = 0; i < middle; i++) {

                    ans.append(s.charAt(left));
                }
            }

            // outward forces
            else if (s.charAt(left) == 'L' && s.charAt(right) == 'R') {

                for (int i = 0; i < middle; i++) {

                    ans.append('.');
                }
            }

            // inward forces
            else {

                for (int i = 0; i < middle / 2; i++) {

                    ans.append('R');
                }

                if (middle % 2 == 1) {
                    ans.append('.');
                }

                for (int i = 0; i < middle / 2; i++) {

                    ans.append('L');
                }
            }

            left = right;
        }

        return ans.toString();
    }

    // Simulate forces repeatedly
    public static String pushDominoesBrute(String dominoes) {

        char[] arr = dominoes.toCharArray();

        boolean changed = true;

        while (changed) {

            changed = false;

            char[] next = arr.clone();

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == '.') {

                    boolean leftR =  (i > 0 && arr[i - 1] == 'R');

                    boolean rightL = (i < arr.length - 1 && arr[i + 1] == 'L');

                    if (leftR && !rightL) {

                        next[i] = 'R';
                        changed = true;
                    }

                    else if (!leftR && rightL) {

                        next[i] = 'L';
                        changed = true;
                    }
                }
            }

            arr = next;
        }

        return new String(arr);
    }
}
