package DSA.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ChemicalFormula {

    public static void main(String[] args) {

        String formula = "((CH))4H2O";
        System.out.println(getWeight(formula));
    }

    public static int getWeight(String formula) {

        char[] charArray = formula.toCharArray();
        int totalWeight = 0;
        Map<Character, Integer> weightMap = new HashMap<>();
        weightMap.put('C', 12);
        weightMap.put('H', 1);
        weightMap.put('O', 16);
        weightMap.put('(', -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<charArray.length; i++) {
            char ch = charArray[i];


            if (weightMap.containsKey(ch)) {
                stack.push(weightMap.get(ch));
            }
            else if (ch == ')') {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek()!= -1) {
                    sum += stack.pop();
                }
                stack.pop();
                stack.push(sum);
            }
            else if (Character.isDigit(ch)) {
                int weight = stack.pop() * (ch - '0');
                stack.push(weight);
            }
        }

        while (!stack.empty()) {
            totalWeight += stack.pop();
        }

        return totalWeight;

    }
}
