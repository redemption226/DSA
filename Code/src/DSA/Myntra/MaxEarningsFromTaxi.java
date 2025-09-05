package DSA.Myntra;

import java.util.Arrays;

public class MaxEarningsFromTaxi {
    public static void main(String[] args) {
        int n = 20;
        int[][] rides = {{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};

        System.out.println(maxTaxiEarnings(n, rides));
    }

        public static long maxTaxiEarnings(int n, int[][] rides) {

            int ridesLength = rides.length;

            //1. First we need to sort the array with start time
            Arrays.sort(rides, (a, b)-> a[0] - b[0]);

            //return f (n, 0, rides, ridesLength);

            long[] dp = new long[ridesLength+1];
            return f (n, 0, rides, ridesLength, dp);

        }

        public static long f(int n, int i, int[][] rides, int ridesLength) {

            if (i == ridesLength)
                return 0;

            int[] rider = rides[i];
            int s = rider[0];
            int e = rider[1];
            int t = rider[2];

            // If we pick the ride, then we need to find the next possible index for our next ride. Next possibe index should start just after or at previous endTime.
            int nextPossibleIndex = findNextPossibleIndex(i+1, e, ridesLength, rides);

            // If not pick, then we just move to next index
            long notPick = f(n, i+1, rides, ridesLength);
            long pick = (e-s) + t + f(n, nextPossibleIndex, rides, ridesLength);

            return Math.max(pick, notPick);
        }

        public static int findNextPossibleIndex(int startIndex, int endTime, int ridesLength, int[][] rides) {
            for (int i=startIndex; i<ridesLength; i++) {
                if (rides[i][0] >= endTime) {
                    return i;
                }
            }
            return ridesLength;
        }

    public static long f(int n, int i, int[][] rides, int ridesLength, long[] dp) {

        dp[ridesLength] =0;

        // If we pick the ride, then we need to find the next possible index for our next ride. Next possibe index should start just after or at previous endTime.

        for (int j = ridesLength-1; j>=0; j--) {
            int[] rider = rides[j];
            int s = rider[0];
            int e = rider[1];
            int t = rider[2];
            int nextPossibleIndex = findNextPossibleIndexBinarySearch(j+1, e, ridesLength, rides);


            // If not pick, then we just move to next index
            long notPick = dp[j+1];
            long pick = (e - s) + t + dp[nextPossibleIndex];

            dp[j] = Math.max(pick, notPick);
        }
        return dp[0];
    }

    public static int findNextPossibleIndexBinarySearch(int startIndex, int endTime, int ridesLength, int[][] rides) {
        int start = startIndex;
        int end = ridesLength;
        int target = endTime;



        while (start < end) {
            int mid = (start + end) /2;
            if (rides[mid][0] >= target) {
                end = mid;
            }
            else
                start = mid+1;
        }
        return end;
    }

}
