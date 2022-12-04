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

    
    private static int part1(ArrayList<String> data) {
        int counter = 0;
        for (int i = 0; i < data.size(); i++) {

            int firstStart = Integer.parseInt(data.get(i).split(",")[0].split("-")[0]);
            int firstEnd = Integer.parseInt(data.get(i).split(",")[0].split("-")[1]);

            int secondStart = Integer.parseInt(data.get(i).split(",")[1].split("-")[0]);
            int secondEnd = Integer.parseInt(data.get(i).split(",")[1].split("-")[1]);

            if ((firstStart <= secondStart && secondEnd <= firstEnd) || 
                (secondStart <= firstStart && firstEnd <= secondEnd)) {
                counter++;
            }

        }
        return counter;
    }

    private static int part2(ArrayList<String> data) {
        int counter = 0;
        for (int i = 0; i < data.size(); i++) {

            int firstStart = Integer.parseInt(data.get(i).split(",")[0].split("-")[0]);
            int firstEnd = Integer.parseInt(data.get(i).split(",")[0].split("-")[1]);

            int secondStart = Integer.parseInt(data.get(i).split(",")[1].split("-")[0]);
            int secondEnd = Integer.parseInt(data.get(i).split(",")[1].split("-")[1]);

            if ((firstStart <= secondStart && secondStart <= firstEnd) ||
                (secondStart <= firstStart && firstStart <= secondEnd)) {
                counter++;
            }

        }
        return counter;
    }

}
