package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import Util.InputHandler;

public class Main {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler(".\\day05\\data.txt");
        ArrayList<String> data = inputHandler.getData();

        String[] stacks = { "DHNQTWVB", "DWB", "TSQWJC", "FJRNZTP", "GPVJMST",
                "BWFTN", "BLDQFHVN", "HPFR", "ZSMBLNPH"
        };

        Stack[] stackArray = generateStack(stacks);

        String result1 = part1(data, stackArray);
        stackArray = generateStack(stacks);
        String result2 = part2(data, stackArray);

        System.out.println(result1);
        System.out.println(result2);

    }

    private static String part1(ArrayList<String> data, Stack[] stack) {
        String result = "";
        for (int i = 0; i < data.size(); i++) {
            int amount = Integer.parseInt(data.get(i).split(" ")[1]);
            int src = Integer.parseInt(data.get(i).split(" ")[3]);
            int dest = Integer.parseInt(data.get(i).split(" ")[5]);

            for (int j = 0; j < amount; j++) {
                stack[dest - 1].push(stack[src - 1].pop());
            }
        }

        for (int i = 0; i < stack.length; i++) {
            result += stack[i].pop();
        }
        return result;
    }

    private static String part2(ArrayList<String> data, Stack[] stackArray) {
        String result = "";
        for (int i = 0; i < data.size(); i++) {
            int amount = Integer.parseInt(data.get(i).split(" ")[1]);
            int src = Integer.parseInt(data.get(i).split(" ")[3]);
            int dest = Integer.parseInt(data.get(i).split(" ")[5]);
            ArrayList toAdd = new ArrayList<>();
            for (int j = 0; j < amount; j++) {
                toAdd.add(stackArray[src - 1].pop());
            }

            Collections.reverse(toAdd);
            for (Object el : toAdd) {
                stackArray[dest - 1].push(el);
            }
        }

        result = "";
        for (int i = 0; i < stackArray.length; i++) {
            result += stackArray[i].pop();
        }
        return result;
    }

    private static Stack[] generateStack(String[] stacks) {
        Stack[] stackArray = new Stack[9];
        for (int i = 0; i < 9; i++) {
            stackArray[i] = new Stack();
            for (int j = 0; j < stacks[i].length(); j++) {
                stackArray[i].push(stacks[i].charAt(j));
            }
        }
        return stackArray;
    }

}
