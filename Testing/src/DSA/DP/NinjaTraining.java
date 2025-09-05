package DSA.DP;

import java.util.Arrays;

/**
Geek is going for a training program for n days.
 He can perform any of these activities: Running, Fighting, and Learning Practice. Each activity
 has some point on each day. As Geek wants to improve all his skills, he can't do the same
 activity on two consecutive days.
 Given a 2D array arr[][] of size n where arr[i][0], arr[i][1], and arr[i][2] represent
 the merit points for Running, Fighting, and Learning on the i-th day, determine the maximum
 total merit points Geek can achieve .

 Input: arr[]= [[1, 2, 5], [3, 1, 1], [3, 3, 3]]
 Output: 11
 Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and on third day
 he will do fighting and earn 3 points so, maximum merit point will be 11.
 Input: arr[]= [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 Output: 6
 Explanation: Geek can perform any activity each day while adhering to the constraints, in order to maximize his total merit points as 6.
 Input: arr[]= [[4, 2, 6]]
 Output: 6
 Explanation: Geek will learn a new move to make his merit points as 6.

 **/
public class NinjaTraining {

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = arr.length;

        System.out.println(ninjaTraining(arr, n-1, 3));

        int dp[][] = new int[n][4];
        for (int i=0; i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(ninjaTrainingMemo(arr, n-1, 3, dp));

        System.out.println(ninjaTrainingDP(arr));

    }

    public static int ninjaTraining(int[][] arr, int day, int last) {

        if (day==0) {
            int maxi = Integer.MIN_VALUE;
            for (int i=0; i<3; i++) {
                if (i != last)
                    maxi = Math.max(maxi, arr[day][i]);
            }
            return maxi;
        }

        int maxi = Integer.MIN_VALUE;

        for (int i=0; i<3; i++) {
            if (i != last) {
                int activity = arr[day][i] + ninjaTraining(arr, day - 1, i);
                maxi = Math.max(maxi,activity);
            }
        }
        return maxi;

    }

    public static int ninjaTrainingMemo(int[][] arr, int day, int last, int[][] dp) {

        if (dp[day][last] != -1)
            return dp[day][last];

        if (day==0) {
            int maxi = Integer.MIN_VALUE;
            for (int i=0; i<3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, arr[day][i]);

                }

            }
            dp[day][last] = maxi;
            return maxi;
        }

        int maxi = Integer.MIN_VALUE;

        for (int i=0; i<3; i++) {
            if (i != last) {
                int activity = arr[day][i] + ninjaTraining(arr, day - 1, i);
                maxi = Math.max(maxi,activity);
            }
        }
        dp[day][last] = maxi;
        return maxi;

    }

    public static int ninjaTrainingDP(int[][] arr) {

        int dp[][] = new int[arr.length][4];

        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));


        int maxi = Integer.MIN_VALUE;

        for (int day = 1; day < arr.length; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task<3; task++) {
                    if (task != last) {
                        int activity = arr[day][task] + dp[day-1][task];
                        maxi = Math.max(maxi,activity);
                    }
                }
                dp[day][last] = maxi;
            }

        }
        return dp[arr.length-1][3];

    }
}
