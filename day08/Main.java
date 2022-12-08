package day08;

import java.util.ArrayList;

import Util.InputHandler;

public class Main {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler(".\\day08\\data.txt");
        ArrayList<String> data = inputHandler.getData();

        System.out.println("Part 1: " + part1(data));
        System.out.println("Part 2: " + part2(data));

    }

    private static int part1(ArrayList<String> data) {
        int visCounter = 0;

        for (int ROWS = 0; ROWS < data.size(); ROWS++) {

            for (int COLS = 0; COLS < data.get(ROWS).length(); COLS++) {

                boolean right = true;
                boolean bot = true;
                boolean left = true;
                boolean top = true;

                for (int i = COLS + 1; i < data.get(ROWS).length(); i++) {
                    if (data.get(ROWS).charAt(i) >= data.get(ROWS).charAt(COLS)) {
                        right = false;
                    }
                }

                for (int i = ROWS + 1; i < data.size(); i++) {
                    if (data.get(i).charAt(COLS) >= data.get(ROWS).charAt(COLS)) {
                        bot = false;
                    }
                }

                for (int i = COLS - 1; i >= 0; i--) {
                    if (data.get(ROWS).charAt(i) >= data.get(ROWS).charAt(COLS)) {
                        left = false;
                    }
                }

                for (int i = ROWS - 1; i >= 0; i--) {
                    if (data.get(i).charAt(COLS) >= data.get(ROWS).charAt(COLS)) {
                        top = false;
                    }
                }

                boolean visible = right || bot || left || top;

                if (visible) {
                    visCounter++;
                }

            }
        }

        return visCounter;
    }

    private static int part2(ArrayList<String> data) {
        int highest = 0;

        for (int ROWS = 0; ROWS < data.size(); ROWS++) {

            for (int COLS = 0; COLS < data.get(ROWS).length(); COLS++) {

                int right = 0;
                int bot = 0;
                int left = 0;
                int top = 0;

                for (int i = COLS + 1; i < data.get(ROWS).length(); i++) {
                    right++;
                    if (data.get(ROWS).charAt(i) >= data.get(ROWS).charAt(COLS)) {
                        break;
                    }
                }

                for (int i = ROWS + 1; i < data.size(); i++) {
                    bot++;
                    if (data.get(i).charAt(COLS) >= data.get(ROWS).charAt(COLS)) {
                        break;
                    }
                }

                for (int i = COLS - 1; i >= 0; i--) {
                    left++;
                    if (data.get(ROWS).charAt(i) >= data.get(ROWS).charAt(COLS)) {
                        break;
                    }
                }

                for (int i = ROWS - 1; i >= 0; i--) {
                    top++;
                    if (data.get(i).charAt(COLS) >= data.get(ROWS).charAt(COLS)) {
                        break;
                    }
                }

                int visible = right * bot * left * top;

                if (visible > highest) {
                    highest = visible;
                }

            }
        }

        return highest;
    }

}
