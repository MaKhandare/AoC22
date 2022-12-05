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

        Stack<Character>[] p1Stack = generateStacks(stacks);
        Stack<Character>[] p2Stack = generateStacks(stacks);

        System.out.println("Part 1: " + part1(data, p1Stack));
        System.out.println("Part 2: " + part2(data, p2Stack));

    }

    private static String part1(ArrayList<String> data, Stack<Character>[] stack) {
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

    private static String part2(ArrayList<String> data, Stack<Character>[] stackArray) {
        String result = "";
        
        for (int i = 0; i < data.size(); i++) {
            int amount = Integer.parseInt(data.get(i).split(" ")[1]);
            int src = Integer.parseInt(data.get(i).split(" ")[3]);
            int dest = Integer.parseInt(data.get(i).split(" ")[5]);

            ArrayList<Character> toAdd = new ArrayList<>();
            for (int j = 0; j < amount; j++) {
                toAdd.add(stackArray[src - 1].pop());
            }

            Collections.reverse(toAdd);
            for (Character c : toAdd) {
                stackArray[dest - 1].push(c);
            }
        }

        for (int i = 0; i < stackArray.length; i++) {
            result += stackArray[i].pop();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private static Stack<Character>[] generateStacks(String[] stacks) {
        Stack<Character>[] stackArray = new Stack[stacks.length];
        for (int i = 0; i < stacks.length; i++) {
            stackArray[i] = new Stack<Character>();
            for (int j = 0; j < stacks[i].length(); j++) {
                stackArray[i].push(stacks[i].charAt(j));
            }
        }
        return stackArray;
    }

}
