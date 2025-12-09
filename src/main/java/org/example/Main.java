package org.example;

import java.util.List;

/**
 * Класс для демонстрации работы метода получения списка людей из
 * заданного CSV файла
 * @author Егор
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        String fileName = "src/main/resources/foreign_names.csv";
        CSVReader csvReader = new CSVReader(fileName);
        try {
            List<Person> personList = csvReader.input();
            for (Person person: personList) {
                System.out.println(person + "\n");
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}