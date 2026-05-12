package string.easy;
/*
Problem - Check If a Word Occurs As a Prefix
of Any Word in a Sentence (LC-1455)


Brute Approach   - Character by character prefix check
Brute T.C        - O(n * m)
Brute S.C        - O(1)

Optimal Approach - Split + startsWith()
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class PrefixWordSearch {

    public static void main(String[] args) {

        String sentence = "i love eating burger";
        String searchWord = "burg";

        //System.out.println("Brute: " + isPrefixOfWordBrute(sentence, searchWord));
        System.out.println("Optimal: " + isPrefixOfWordOptimal(sentence,  searchWord));
    }

    // Split + startsWith()
    public static int isPrefixOfWordOptimal(String sentence, String searchWord) {

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {

            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }

    // Manual prefix checking
    public static int isPrefixOfWordBrute(String sentence, String searchWord) {

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {

            if (isPrefix(words[i], searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }

    // Manual prefix function
    public static boolean isPrefix(String word, String prefix) {

        if (prefix.length() > word.length()) {
            return false;
        }

        for (int i = 0; i < prefix.length(); i++) {

            if (word.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}