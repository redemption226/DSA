package DSA.Interviews;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        int n = nums.length;
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        int n = nums.length;

        for (int i=0 ;i<n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));

        if (arr[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String s: arr)
            sb.append(s);

        return sb.toString();
    }
}
