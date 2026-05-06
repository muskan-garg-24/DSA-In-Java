package story_based.easy;
/*
Problem - Apple and Orange (HackerRank)
Approach : Simple Traversal / Simulation

Optimal T.C - O(n + m)
        S.C - O(1)
*/

public class AppleOrange {
    public static void main(String[] args) {

        int s = 7, t = 11;
        int a = 5, b = 15;

        int[] apples = {-2, 2, 1};
        int[] oranges = {5, -6};

        countFruits(s, t, a, b, apples, oranges);
    }
    
    public static void countFruits(int s, int t, int a, int b, int[] apples, int[] oranges) {

        int appleCount = 0;
        int orangeCount = 0;

        for (int d : apples) {
            if (a + d >= s && a + d <= t) {
                appleCount++;
            }
        }

        for (int d : oranges) {
            if (b + d >= s && b + d <= t) {
                orangeCount++;
            }
        }

        System.out.println("Apples: " + appleCount);
        System.out.println("Oranges: " + orangeCount);
    } 
}
