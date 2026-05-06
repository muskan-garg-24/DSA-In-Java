package story_based.easy;
/*
Problem - Drawing Book (HackerRank)
Approach : Math Optimisation

Brute   T.C - O(n)
        S.C - O(1)

Optimal T.C - O(1)
        S.C - O(1)
*/

public class DrawingBook {
    public static void main(String[] args) {
        int n = 6;
        int p = 2;

        //System.out.println("Brute: " + pageCountBrute(n, p));
        System.out.println("Optimal: " + pageCountOptimal(n, p));
    }

    public static int pageCountBrute(int n, int p) {
        int count = 0;
        int page = 1;

        // from front
        while (page < p) {
            page += 2;
            count++;
        }

        int front = count;

        // from back
        count = 0;
        page = (n % 2 == 0) ? n : n - 1;

        while (page > p) {
            page -= 2;
            count++;
        }

        int back = count;

        return Math.min(front, back);
    }

    public static int pageCountOptimal(int n, int p) {
        int fromFront = p / 2;
        int fromBack = (n / 2) - (p / 2);

        return Math.min(fromFront, fromBack);
    }
}
