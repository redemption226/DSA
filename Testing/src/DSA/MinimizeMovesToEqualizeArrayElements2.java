package DSA;

/*
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment or decrement an element of the array by 1.

Test cases are designed so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
Example 2:

Input: nums = [1,10,2,9]
Output: 16
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimizeMovesToEqualizeArrayElements2 {

    public static void main(String[] args) {
        int[] nums = {1,10,2,9};
        int n = nums.length;

        Arrays.sort(nums);

        int median = nums[n/2];

        int moves = 0;
        for (int x: nums) {
            moves += Math.abs(median-x);
        }

        System.out.println(moves);
    }
}
