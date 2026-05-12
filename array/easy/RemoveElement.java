package array.easy;
/*
Problem - Remove Element (LC-27)

Brute Approach   - Use extra array
Brute T.C        - O(n)
Brute S.C        - O(n)

Optimal Approach - Two Pointers
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class RemoveElement {

    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        //int[] bruteArr = nums.clone();
        //int bruteLen = removeElementBrute(bruteArr, val);

        int[] optimalArr = nums.clone();
        int optimalLen = removeElementOptimal(optimalArr, val);

        //System.out.println("Brute Length: " + bruteLen);
        System.out.println("Optimal Length: " + optimalLen);
    }

    // Two pointers
    public static int removeElementOptimal(int[] nums, int val) {

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // keep valid element
            if (nums[right] != val) {

                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    // Extra array
    public static int removeElementBrute(int[] nums, int val) {

        int[] temp = new int[nums.length];

        int index = 0;

        for (int num : nums) {

            if (num != val) {

                temp[index++] = num;
            }
        }

        // copy back
        for (int i = 0; i < index; i++) {

            nums[i] = temp[i];
        }

        return index;
    }
}