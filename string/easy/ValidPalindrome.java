package string.easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println("Optimal: " + isPalindromeOptimal(s));
        //System.out.println("Brute: " + isPalindromeBrute(s));
    }

    // ✅ Optimal Approach (Two Pointer)
    // T.C = O(n), S.C = O(1)
    public static boolean isPalindromeOptimal(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char chLeft = s.charAt(left);
            char chRight = s.charAt(right);

            // skip non-alphanumeric
            if (!Character.isLetterOrDigit(chLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(chRight)) {
                right--;
            } else {
                if (Character.toLowerCase(chLeft) != Character.toLowerCase(chRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    // ✅ Brute Force Approach
    // T.C = O(n), S.C = O(n)
    public static boolean isPalindromeBrute(String s) {
        StringBuilder cleaned = new StringBuilder();

        // remove special chars & lowercase
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                cleaned.append(Character.toLowerCase(ch));
            }
        }

        String str = cleaned.toString();
        String reversed = new StringBuilder(str).reverse().toString();

        return str.equals(reversed);
    } 
}
