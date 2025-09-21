package DSA.Arrays;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        int[] arr =  { 1, 2, 3, 4, 5 };

        int n = 5;
        System.out.println(Arrays.toString(wigleSort(arr, n)));
    }

    public static int[] wigleSort(int[] arr, int n) {
        for (int i=1; i<n; i++) {
            if ((i%2 == 0 && arr[i] > arr[i-1] )
                    || (i%2==1 && arr[i] < arr[i-1]))  {
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
        }
        return arr;
    }
}
