package day06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Util.InputHandler;

public class Main {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler(".\\day06\\data.txt");
        ArrayList<String> data = inputHandler.getData();

        System.out.println("Part 1: " + part1(data));
        System.out.println("Part 2: " + part2(data));

    }

    private static int part1(ArrayList<String> data) {

        for (int i = 0; i < data.get(0).length(); i++) {

            Set<Character> s1 = new HashSet<>();
            for (int j = 0; j < 4; j++) s1.add(data.get(0).charAt(i + j));
            
            if (s1.size() == 4) return i + 4;
        }

        return -1;
    }

    private static int part2(ArrayList<String> data) {

        for (int i = 0; i < data.get(0).length(); i++) {
            
            Set<Character> s1 = new HashSet<>();
            for (int j = 0; j < 14; j++) s1.add(data.get(0).charAt(i + j));

            if (s1.size() == 14) return i + 14;
            
        }

        return -1;
    }
}
