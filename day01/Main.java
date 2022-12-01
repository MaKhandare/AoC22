package day01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> data = new ArrayList<>();

        String fileName = "c:\\dev\\AoC22\\day01\\data.txt";
        FileReader fileReader = new FileReader(fileName);

        int sum = 0;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    sum += Integer.parseInt(line);
                } else {
                    data.add(sum);
                    sum = 0;
                }
            }
        }

        Collections.sort(data);

        System.out.println(data.get(data.size()-1));
        System.out.println(data.get(data.size()-2));
        System.out.println(data.get(data.size()-3));

        sum = 0;
        sum = data.get(data.size()-1) + data.get(data.size()-2) + data.get(data.size()-3);
        System.out.println(sum);

    }
}
