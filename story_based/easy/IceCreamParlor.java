package story_based.easy;
/*
Problem - Ice Cream Parlor (HackerRank)
Approach :  Hashing (Two Sum)

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(n)
*/

import java.util.*;

public class IceCreamParlor {
    public static void main(String[] args) {
        int m = 6;
        int[] arr = {1, 3, 4, 5, 6};

        //icecreamBrute(m, arr);
        icecreamOptimal(m, arr);
    }

    public static void icecreamBrute(int m, int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == m) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }

    public static void icecreamOptimal(int m, int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = m - arr[i];

            if (map.containsKey(complement)) {
                System.out.println((map.get(complement) + 1) + " " + (i + 1));
                return;
            }

            map.put(arr[i], i);
        }
    }
}