package Util;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InputHandler {

    ArrayList<String> data;
    FileReader fileReader;

    public InputHandler(String fileName) {
        data = new ArrayList<>();

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            InitData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void InitData() throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
        }

    }

    public ArrayList<String> getData() {
        return data;
    }

}