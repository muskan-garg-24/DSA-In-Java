/* This code contains both brute and optimal solutions

Problem - Container with most water  (Leet code - 11)
Asked in: Google, Amazon, Microsoft
Pattern - Two Pointer
Brute   T.C - O(n^2)
        S.C - O(1)
        
Optimal T.C - O(n)
        S.C - O(1)
*/

package array.medium;

public class ContainerWithMostWater {
  public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Optimal: " + maxAreaOptimal(height));
        //System.out.println("Brute: " + maxAreaBrute(height));

    }

    public static int maxAreaOptimal(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;

            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
      public static int maxAreaBrute(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int width = j - i;
                int area = h * width;

                max = Math.max(max, area);
            }
        }
        return max;
    }  
}
