package story_based.easy;
/*
Problem - Sales by Match (HackerRank)
Approach : Hashing (Frequency Counting)

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(n)
*/

import java.util.*;

public class SalesByMatch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 3, 2};

        //System.out.println("Brute: " + sockMerchantBrute(arr));
        System.out.println("Optimal: " + sockMerchantOptimal(arr));
    }

    public static int sockMerchantBrute(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            for (int j = i + 1; j < n; j++) {
                if (!visited[j] && arr[i] == arr[j]) {
                    pairs++;
                    visited[i] = true;
                    visited[j] = true;
                    break;
                }
            }
        }

        return pairs;
    }

    public static int sockMerchantOptimal(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;

        for (int count : map.values()) {
            pairs += count / 2;
        }

        return pairs;
    }
}