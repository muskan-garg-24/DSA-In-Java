package string.easy;
/*
Problem - Reverse Vowels of a String (LC-345)

Brute Approach   - Store vowels separately and reverse
Brute T.C        - O(n)
Brute S.C        - O(n)

Optimal Approach - Two Pointers
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

import java.util.*;

public class ReverseVowels {

    public static void main(String[] args) {

        String s = "hello";

        //System.out.println("Brute: " + reverseVowelsBrute(s));
        System.out.println("Optimal: " + reverseVowelsOptimal(s));
    }

    // Two pointers
    public static String reverseVowelsOptimal(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // move left pointer
            while (left < right && !isVowel(arr[left])) {

                left++;
            }

            // move right pointer
            while (left < right && !isVowel(arr[right])) {

                right--;
            }

            // swap vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    // Store vowels and reverse them
    public static String reverseVowelsBrute(String s) {

        List<Character> vowels = new ArrayList<>();

        // collect vowels
        for (char ch : s.toCharArray()) {

            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        char[] arr = s.toCharArray();

        int index = vowels.size() - 1;

        // replace vowels in reverse order
        for (int i = 0; i < arr.length; i++) {

            if (isVowel(arr[i])) {

                arr[i] = vowels.get(index);
                index--;
            }
        }

        return new String(arr);
    }

    // vowel check
    public static boolean isVowel(char ch) {

        ch = Character.toLowerCase(ch);

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}