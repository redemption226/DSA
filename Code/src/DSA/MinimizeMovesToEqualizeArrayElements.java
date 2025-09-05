package DSA;

/*

Given an array arr[] of N integers, For each move, you can select any m (1 <= m <= n) elements from the array and transfer one integer unit from each selected element to one of its adjacent elements at the same time, the task is to find the minimum number of moves needed to make all the integers in the array equal. If it's not possible to achieve this, return -1.

Examples:

Input: arr = {1, 0, 5}
Output: 3
Explanation: 1st move:    1        0 <-- 5    =>    1     1     4
                        2nd move:  1 <-- 1 <-- 4    =>    2     1     3
                        3rd move:   2       1 <-- 3    =>    2     2     2



Input: arr = [0,3,0]
Output: 2
Explanation: 1st move:    0 <-- 3       0    =>    1     2     0
                        2nd move:  1        2 --> 0    =>    1     1     1


 */

public class MinimizeMovesToEqualizeArrayElements {

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        System.out.println(minimize(arr));
    }

    public static int minimize(int[] arr) {
        int sum = 0;
        for (int x : arr)
            sum+=x;

        int target = sum/arr.length;

        if (target == 0)
            return -1;

        int negMoves = 0;
        int posMoves = 0;

        for (int x : arr) {
            int move = x - target;
            if (move < 0)
                negMoves+= move;
            else if (move > 0)
                posMoves+= move;
        }
        return Math.max(negMoves, posMoves);
    }
}
