package DSA.BinarySearch;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        int min = 1;
        int ans = max;   // now correct

        while (min <= max) {
            int k = min + (max - min) / 2;

            if (canEatBananas(k, h, piles)) {
                ans = k;
                max = k - 1;
            } else {
                min = k + 1;
            }
        }

        return ans;
    }

    public boolean canEatBananas(int k, int h, int[] piles) {
        long hours = 0;   // use long to avoid overflow

        for (int bananas : piles) {
            hours += (bananas + k - 1) / k;   // faster than Math.ceil
        }

        return hours <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(koko.minEatingSpeed(piles, h)); // Output: 4
    }
}
