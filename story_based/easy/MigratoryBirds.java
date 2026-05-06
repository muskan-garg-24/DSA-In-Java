package story_based.easy;
/*
Problem - Migratory Birds (HackerRank)
Approach : Hashing

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1)
*/

public class MigratoryBirds {
    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 4, 5, 3};

        //System.out.println("Brute: " + migratoryBrute(arr));
        System.out.println("Optimal: " + migratoryOptimal(arr));
    }
   
    public static int migratoryBrute(int[] arr) {
        int n = arr.length;
        int maxFreq = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > maxFreq || (count == maxFreq && arr[i] < result)) {
                maxFreq = count;
                result = arr[i];
            }
        }

        return result;
    }

    public static int migratoryOptimal(int[] arr) {

        int[] freq = new int[6];

        for (int id : arr) {
            freq[id]++;
        }

        int maxFreq = 0;
        int result = 0;

        for (int i = 1; i <= 5; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                result = i;
            }
        }
        return result;
    }
}