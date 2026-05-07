package story_based.easy;
/*
Problem - Save Ironman (HackerEarth)

Brute Approach   - Create cleaned string then check palindrome
Brute T.C        - O(n)
Brute S.C        - O(n)

Optimal Approach - Two Pointer + In-place comparison
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

class SaveIronman {

    public static void main(String args[]) throws Exception {

        String s = "I am :IronnorI Ma, i";

            if (saveIronmanOptimal(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        
            // if (saveIronmanBrute(s)) {
            //     System.out.println("YES");
            // } else {
            //     System.out.println("NO");
            // }
    }

    public static boolean saveIronmanOptimal(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // skip non-alphanumeric characters from left
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // skip non-alphanumeric characters from right
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare ignoring case
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    
     // Create cleaned string then check palindrome
    public static boolean saveIronmanBrute(String s) {

        String cleaned = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned += Character.toLowerCase(ch);
            }
        }

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {

            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
