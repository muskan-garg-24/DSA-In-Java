package string.medium;
/*
Problem - Minimum Penalty for a Shop (LC-2483)

Brute Approach   - Check every closing hour
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Prefix + Suffix Count
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/


public class MinimumPenaltyShop {

    public static void main(String[] args) {

        String customers = "YYNY";

        //System.out.println("Brute: " + bestClosingTimeBrute(customers));
        System.out.println("Optimal: " + bestClosingTimeOptimal(customers));
    }

    // Prefix + suffix logic
    public static int bestClosingTimeOptimal(String customers) {

        int penalty = 0;

        // Initial penalty if closed at hour 0
        for (char ch : customers.toCharArray()) {

            if (ch == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {

            // Shop stays open for Y -> reduce penalty
            if (customers.charAt(i) == 'Y') {
                penalty--;
            }

            // Shop stays open for N -> increase penalty
            else {
                penalty++;
            }

            if (penalty < minPenalty) {

                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }

    // Try every closing hour
    public static int bestClosingTimeBrute(String customers) {

        int n = customers.length();

        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

        for (int hour = 0; hour <= n; hour++) {

            int penalty = 0;

            // Before closing
            for (int i = 0; i < hour; i++) {

                if (customers.charAt(i) == 'N') {
                    penalty++;
                }
            }

            // After closing
            for (int i = hour; i < n; i++) {

                if (customers.charAt(i) == 'Y') {
                    penalty++;
                }
            }

            if (penalty < minPenalty) {

                minPenalty = penalty;
                bestHour = hour;
            }
        }

        return bestHour;
    }
}