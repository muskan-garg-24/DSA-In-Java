/*
Problem - Fruits Into Baskets (LC-904)
Pattern - Sliding Window + Hashing
Asked in: Amazon,Google

Brute   T.C - O(n^2)
        S.C - O(n)

Optimal T.C - O(n)
        S.C - O(n)
*/

package array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntobasket {
public static void main(String[] args) {

        int[] fruits = {1,2,1,2,3};

        System.out.println("Brute: " + totalFruitBrute(fruits));
        System.out.println("Optimal: " + totalFruitOptimal(fruits));
    }

    public static int totalFruitOptimal(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {

            // add fruit
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // shrink if more than 2 types
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static int totalFruitBrute(int[] fruits) {

        int maxLen = 0;

        // generate all subarrays
        for (int i = 0; i < fruits.length; i++) {

            Set<Integer> set = new HashSet<>();

            for (int j = i; j < fruits.length; j++) {

                set.add(fruits[j]);

                if (set.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }
}
