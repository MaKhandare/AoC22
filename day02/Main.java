package day02;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileName = ".\\day02\\data.txt";
        FileReader fileReader = new FileReader(fileName);

        int score = 0;
        int score2 = 0;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                String opponent = parts[0];
                String player = parts[1];

                score = part1(score, opponent, player);
                score2 = part2(score2, opponent, player);
            }
        }

        System.out.println("Part 1: " + score);
        System.out.println("Part 2: " + score2);

    }

    private static int part1(int score, String opponent, String player) {
        // A=rock, B=paper, C=scissors
        // X=rock, Y=paper, Z=scissors

        // score player plays rock=1, paper=2, scissor=3
        // 0=lost 6=win 3=draw
        if (player.equals("X")) { // rock
            score += 1;

            if (opponent.equals("A")) {
                score += 3;
            }

            if (opponent.equals("C")) {
                score += 6;
            }
        }

        if (player.equals("Y")) { // paper
            score += 2;

            if (opponent.equals("B")) {
                score += 3;
            }

            if (opponent.equals("A")) {
                score += 6;
            }
        }

        if (player.equals("Z")) { // scissor
            score += 3;

            if (opponent.equals("C")) {
                score += 3;
            }

            if (opponent.equals("B")) {
                score += 6;
            }
        }
        return score;
    }

    private static int part2(int score2, String opponent, String player) {
        // X = lose
        // Y = draw
        // Z = win
        if (opponent.equals("A")) { // rock

            if (player.equals("X")) {
                score2 += 3;
            }
            if (player.equals("Y")) {
                score2 += 4;
            }

            if (player.equals("Z")) {
                score2 += 8;
            }

        }

        if (opponent.equals("B")) { // paper

            if (player.equals("X")) {
                score2 += 1;
            }

            if (player.equals("Y")) {
                score2 += 5;
            }

            if (player.equals("Z")) {
                score2 += 9;
            }

        }

        if (opponent.equals("C")) { // scissors

            if (player.equals("X")) {
                score2 += 2;
            }

            if (player.equals("Y")) {
                score2 += 6;
            }

            if (player.equals("Z")) {
                score2 += 7;
            }

        }
        return score2;
    }
}
