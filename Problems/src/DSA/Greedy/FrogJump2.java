package DSA.Greedy;

public class FrogJump2 {

    public static void main(String[] args) {
        System.out.println(maxJump(new int[]{0,2,5,6,7}));
    }

    public static int maxJump(int[] stones) {

        // Assume we have 2 frogs and we are traversing from start
        // First frog jumps from start stone to even stones.
        // Second frog jumps from start to odd stones -> Similar to traversing backwards.
        int n = stones.length;

        int res = stones[1] - stones[0];

        //Traverse even stones
        for (int i = 2; i<n; i=i+2) {
            res = Math.max(res, stones[i] - stones[i-2]);
        }

        //Traverse odd stones
        for (int i = 3; i<n; i=i+2) {
            res = Math.max(res, stones[i] - stones[i-2]);
        }

        return res;
    }
}
