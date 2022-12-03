package day03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import Util.InputHandler;

public class Main {
    public static void main(String[] args) throws IOException {

        // maybe also possible with sets instead of char comparisons?
        InputHandler inputHandler = new InputHandler(".\\day03\\data.txt");
        ArrayList<String> data = inputHandler.getData();

        int sum = part1(data);
        int sum2 = part2(data);

        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + sum2);

    }

    private static int part1(ArrayList<String> data) {
        HashSet<Character> s1 = new HashSet<>();
        HashSet<Character> s2 = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < data.size(); i++) {
            String str1 = data.get(i).substring(0, data.get(i).length() / 2);
            String str2 = data.get(i).substring(data.get(i).length() / 2);

            for (int j = 0; j < str1.length(); j++) {
                s1.add(str1.charAt(j));
            }

            for (int j = 0; j < str2.length(); j++) {
                s2.add(str2.charAt(j));
            }

            s1.retainAll(s2);

            for (Character c : s1) {
                if (Character.isUpperCase(c)) {
                    sum += c - 38;
                } else {
                    sum += c - 96;
                }
            }

            s1.clear();
            s2.clear();
        }

        return sum;
    }

    private static int part2(ArrayList<String> data) {
        HashSet<Character> s1 = new HashSet<>();
        HashSet<Character> s2 = new HashSet<>();
        HashSet<Character> s3 = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < data.size(); i += 3) {
            String str1 = data.get(i);
            String str2 = data.get(i + 1);
            String str3 = data.get(i + 2);

            for (int j = 0; j < str1.length(); j++) {
                s1.add(str1.charAt(j));
            }

            for (int j = 0; j < str2.length(); j++) {
                s2.add(str2.charAt(j));
            }

            for (int j = 0; j < str3.length(); j++) {
                s3.add(str3.charAt(j));
            }

            s2.retainAll(s3);
            s1.retainAll(s2);

            for (Character c : s1) {
                if (Character.isUpperCase(c)) {
                    sum += c - 38;
                } else {
                    sum += c - 96;
                }
            }

            s1.clear();
            s2.clear();
            s3.clear();
        }

        return sum;
    }

}
