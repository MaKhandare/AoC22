package day11;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> data = new ArrayList<>();

        String fileName = "c:\\dev\\AoC22\\day1\\data.txt";
        FileReader fileReader = new FileReader(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(Integer.parseInt(line));
            }
        }

    }
}
