package story_based.easy;
/*
Problem - Kids With the Greatest Number of Candies (LC-1431)

Brute   T.C - O(n^2)
        S.C - O(1)

Optimal T.C - O(n)
        S.C - O(1) (excluding output)
*/

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
  public static void main(String[] args) {

        int[] candies = {2,3,5,1,3};
        int extra = 3;

        //System.out.println("Brute: " + kidsWithCandiesBrute(candies, extra));
        System.out.println("Optimal: " + kidsWithCandiesOptimal(candies, extra));
    }

    public static List<Boolean> kidsWithCandiesOptimal(int[] candies, int extra) {

        List<Boolean> result = new ArrayList<>();

        //find max
        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }

        //compare
        for (int c : candies) {
            result.add(c + extra >= max);
        }

        return result;
    }

    public static List<Boolean> kidsWithCandiesBrute(int[] candies, int extra) {

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {

            int newVal = candies[i] + extra;

            boolean isMax = true;

            for (int j = 0; j < candies.length; j++) {
                if (newVal < candies[j]) {
                    isMax = false;
                    break;
                }
            }

            result.add(isMax);
        }

        return result;
    }
}

