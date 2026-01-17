package DSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> finalList = new ArrayList();
        Arrays.sort(arr);
        int n = arr.length;
        int minAbsDiff = arr[n-1] - arr[0];

        for (int i=0; i<n-1; i++) {
            if (arr[i] < arr[i+1] && arr[i+1] - arr[i] < minAbsDiff) {
                finalList = new ArrayList();
                minAbsDiff = arr[i+1] - arr[i];
                finalList.add(List.of(arr[i], arr[i+1]));

            }
            else if (arr[i+1] - arr[i] == minAbsDiff) {
                finalList.add(List.of(arr[i], arr[i+1]));
            }
        }
        return finalList;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        System.out.println(minimumAbsDifference(arr));
    }
}
