package DSA.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Pair> stack = new Stack();

        int n = temperatures.length;
        int[] finalArray = new int[n];

        for (int i=0; i<n; i++) {

            while (!stack.empty() && stack.peek().first < temperatures[i]) {
                Pair pair = stack.pop();
                finalArray[pair.second] = i - pair.second;
            }

            stack.push(new Pair(temperatures[i], i));

        }

        return finalArray;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
