package org.example;

import java.util.*;
import java.io.*;

public class CSVReader {
    private List<Person> result;
    private String fileName;
    public CSVReader(String _fileName) {
        fileName = _fileName;
        result = new ArrayList<>();
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String _fileName) {
        fileName = _fileName;
    }
    public List<Person> input() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String str = scanner.nextLine();
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            str = str.replace(" ", "");
            if (!str.isEmpty()) {
                String[] cols = str.split(";");
                Person person = new Person(Integer.parseInt(cols[0]), cols[1], cols[2], new Department(cols[4]),
                        Integer.parseInt(cols[5]), cols[4]);
                result.add(person);
            }
        }
        scanner.close();
        return result;
    }
}
