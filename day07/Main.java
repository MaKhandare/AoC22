package day07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import Util.InputHandler;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(".\\day07\\data.txt");
        ArrayList<String> data = inputHandler.getData();

        Map<String, Integer> directorySizes = getDirectorySizes(data);
        System.out.println("Part 1: " + part1(directorySizes));
        System.out.println("Part 2: " + part2(directorySizes));
    }

    private static int part1(Map<String, Integer> directorySizes) {
        return directorySizes
                .values()
                .stream()
                .mapToInt(e -> e)
                .filter(e -> e <= 100000)
                .sum();
    }

    private static int part2(Map<String, Integer> directorySizes) {

        int TOTAL_SIZE = 70000000;
        int NEEDED_SIZE = 30000000;
        int USED_SPACE = directorySizes.get("/");

        return directorySizes
                .values()
                .stream()
                .mapToInt(e -> e)
                .filter(e -> (TOTAL_SIZE - USED_SPACE + e) > NEEDED_SIZE)
                .min()
                .orElseThrow(() -> new RuntimeException("ff"));

    }

    private static Map<String, Integer> getDirectorySizes(ArrayList<String> data) {

        Map<String, Integer> directorySizes = new HashMap<>();
        Deque<String> directoryStack = new ArrayDeque<>();

        for (int i = 0; i < data.size(); i++) {

            if (data.get(i).charAt(0) == '$') {

                String command = data.get(i).substring(2);
                if (command.startsWith("cd ")) {

                    String dir = command.substring(3);

                    if (dir.equals("..")) {
                        directoryStack.pop();

                    }

                    else if (dir.equals("/")) {
                        directoryStack.clear();
                        directoryStack.push("/");
                    }

                    else {
                        directoryStack.push(directoryStack.peek() + "/" + dir);
                    }

                    directorySizes.putIfAbsent(directoryStack.peek(), 0);

                }

                else if (command.startsWith("ls")) {
                    continue;
                }

                else {
                    System.out.println("this should not happen. why are you PRINTING BUD?");
                }

            } else {

                String field1 = data.get(i).substring(0, data.get(i).indexOf(" "));

                if (!field1.equals("dir")) {
                    int size = Integer.parseInt(field1);
                    Deque<String> copy = new ArrayDeque<>(directoryStack);
                    while (!copy.isEmpty()) {
                        directorySizes.compute(copy.pop(), (ig, oldSize) -> oldSize + size);
                    }
                }
            }

        }

        return directorySizes;
    }
}
