package DSA.DP.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPairs {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int k = 2;
        int n = arr.length-1;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();

        getAllPairs(arr, k, n,list,finalList);
        System.out.println(finalList);
    }

    public static void getAllPairs(int[] arr, int k, int n, List<Integer> list, List<List<Integer>> finalList) {

        if (n < 0 || k < 0) {
            return;
        }
        if (k == 0) {
            List<Integer> temp = new ArrayList<>(list);
            finalList.add(temp);
            return;
        }

        list.add(arr[n]);
        getAllPairs(arr, k - 1, n - 1, list, finalList);
        if (list.size() > 0)
            list.remove(list.size() - 1);
        getAllPairs(arr, k, n - 1, list, finalList);
    }
}
