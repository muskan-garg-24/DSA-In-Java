package string.easy;

public class RansomeNote {
  public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println("Brute: " + canConstructBrute(ransomNote, magazine));
        System.out.println("Optimal: " + canConstructOptimal(ransomNote, magazine));
    }

    public static boolean canConstructOptimal(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // count magazine characters
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        // check ransomNote
        for (char c : ransomNote.toCharArray()) {

            if (freq[c - 'a'] == 0) return false;

            freq[c - 'a']--; // use character
        }

        return true;
    }

    public static boolean canConstructBrute(String ransomNote, String magazine) {

        StringBuilder sb = new StringBuilder(magazine);

        for (char c : ransomNote.toCharArray()) {

            int index = sb.indexOf(String.valueOf(c));

            if (index == -1) return false;

            sb.deleteCharAt(index); // remove used char
        }

        return true;
    }
}
