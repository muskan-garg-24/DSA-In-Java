package story_based.easy;

// public class BillDivision {
  
// }
/*
Problem - Bill Division (HackerRank)
Approach : Simple Traversal + Array Sum

Optimal T.C - O(n)
        S.C - O(1)
*/

public class BillDivision {
    public static void main(String[] args) {
        int[] bill = {3, 10, 2, 9};
        int k = 1;
        int b = 12;
        bonAppetit(bill, k, b);
    }

    public static void bonAppetit(int[] bill, int k, int b) {
        int sum = 0;

        for (int i = 0; i < bill.length; i++) {
            if (i != k) {
                sum += bill[i];
            }
        }

        int fairShare = sum / 2;

        if (fairShare == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - fairShare);
        }
    }
}