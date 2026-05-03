/* This code contains both brute and optimal functions

Problem - Trapping Rain Water (Leet code - 42)
Asked in: Amazon, Google, Adobe
Pattern - Two Pointer
Brute   T.C - O(n^2)
        S.C - O(1)
        
Optimal T.C - O(n)
        S.C - O(1)
*/

package array.hard;

public class TrappingRainWater {
  public static void main(String[] args) {
    int[] height = {4,2,0,3,2,5};
    System.out.println("Optimal: " + trapOptimal(height));
    //System.out.println("Brute: " + trapBrute(height));
    }

    public static int trapOptimal(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
      public static int trapBrute(int[] height) {
        int n = height.length;
        int water = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;

            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }
}
