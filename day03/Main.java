package day03;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<String> data = new ArrayList<>();

        String fileName = ".\\day03\\data.txt";
        FileReader fileReader = new FileReader(fileName);

        int sum = 0;
        int sum2 = 0;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                // System.out.println(line);
                data.add(line);
                // String s1 = line.substring(0, line.length() / 2);
                // String s2 = line.substring(line.length() / 2);
                // sum = extracted(sum, s1, s2);

            }
        }

        System.out.println(data);

        sum2 = extracted2(data, sum2);
        // sum2 = extracted2(data, sum2);

        // System.out.println(sum);
        System.out.println(sum2);

    }

    private static int extracted2(ArrayList<String> data, int sum2) {
        for (int i = 0; i < data.size(); i += 3) {

            String elfA = data.get(i);
            String elfB = data.get(i + 1);
            String elfC = data.get(i + 2);

            System.out.println("A: " + elfA);
            System.out.println("B: " + elfB);
            System.out.println("C: " + elfC);

            sum2 = getCom(elfA, elfB, elfC, sum2);
        }
        return sum2;
    }

    private static int getCom(String elfA, String elfB, String elfC, int sum2) {
        for (int j = 0; j < elfA.length(); j++) {
            for (int k = 0; k < elfB.length(); k++) {

                if (elfA.charAt(j) == elfB.charAt(k)) {

                    for (int l = 0; l < elfC.length(); l++) {
                        if (elfB.charAt(k) == elfC.charAt(l)) {
                            System.out.println(elfC.charAt(l));

                            if (Character.isLowerCase(elfC.charAt(l))) {
                                sum2 += (int) elfC.charAt(l) - 96;
                                return sum2;
                            }

                            else {
                                sum2 += (int) elfC.charAt(l) - 38;
                                return sum2;
                            }
                        }
                    }
                }
            }
        }

        return sum2;
    }

    private static int extracted(int sum, String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    System.out.println(s2.charAt(j));

                    if (Character.isLowerCase(s2.charAt(j))) {
                        // System.out.println((int) s2.charAt(j) - 96);
                        sum += (int) s2.charAt(j) - 96;
                        return sum;
                    }

                    else {
                        // System.out.println((int) s2.charAt(j) - 38);
                        sum += (int) s2.charAt(j) - 38;
                        return sum;

                    }

                }
            }
        }
        return sum;
    }
}
