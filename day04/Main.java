package day04;

import java.util.ArrayList;

import Util.InputHandler;

public class Main {
    public static void main(String[] args) {

        InputHandler input = new InputHandler(".\\day04\\data.txt");
        ArrayList<String> data = input.getData();

        int counter = part1(data);
        int counter2 = part2(data);

        System.out.println("Part 1: " + counter);
        System.out.println("Part 2: " + counter2);

    }

    private static int part2(ArrayList<String> data) {
        int counter = 0;
        for (int i = 0; i < data.size(); i++) {

            String arr[] = data.get(i).split(",");
            String first = arr[0];
            String second = arr[1];

            String arr2[] = first.split("-");
            int firstStart = Integer.parseInt(arr2[0]);
            int firstEnd = Integer.parseInt(arr2[1]);

            String arr3[] = second.split("-");
            int secondStart = Integer.parseInt(arr3[0]);
            int secondEnd = Integer.parseInt(arr3[1]);

            if ((firstStart <= secondStart && secondStart <= firstEnd)
                    || (secondStart <= firstStart && firstStart <= secondEnd)) {
                counter++;
            }

        }
        return counter;
    }

    private static int part1(ArrayList<String> data) {
        int counter = 0;
        for (int i = 0; i < data.size(); i++) {

            String arr[] = data.get(i).split(",");
            String first = arr[0];
            String second = arr[1];

            String arr2[] = first.split("-");
            int firstStart = Integer.parseInt(arr2[0]);
            int firstEnd = Integer.parseInt(arr2[1]);

            String arr3[] = second.split("-");
            int secondStart = Integer.parseInt(arr3[0]);
            int secondEnd = Integer.parseInt(arr3[1]);

            if ((firstStart <= secondStart && firstEnd >= secondEnd)
                    || (secondStart <= firstStart && secondEnd >= firstEnd)) {
                counter++;
            }

        }
        return counter;
    }

}
