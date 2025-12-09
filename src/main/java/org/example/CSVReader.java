package org.example;

import java.util.*;
import java.io.*;

/**
 * Класс, позволяющий считать информацию
 * из заданного CSV файла и извлечь из него
 * информацию и людях и вывести её в виде их списка
 * @author Егор
 * @version 1.0
 */

public class CSVReader {
    private List<Person> result;
    private String fileName;

    /**
     * Конструктор класса CSVReader с указанием пути
     * к заданному CSV файлу
     * @param _fileName строка, в которой содержится путь к CSV файлу
     */

    public CSVReader(String _fileName) {
        fileName = _fileName;
        result = new ArrayList<>();
    }

    /**
     * Получение строки, в которой содержится путь
     * к заданному CSV файлу
     * @return строка, в которой содержится путь к CSV файлу
     */

    public String getFileName() {
        return fileName;
    }

    /**
     * Установление строки, в которой содержится путь
     * к заданному CSV файлу
     * @param _fileName строка, в которой содержится путь к CSV файлу
     */

    public void setFileName(String _fileName) {
        fileName = _fileName;
    }

    /**
     * Получение данных из заданного ранее CSV файла
     * с извлечением информации о людях и
     * дальнейшим созданием списка людей
     * @return список людей
     * @throws FileNotFoundException, если файл по заданному ранее
     * пути не найден
     */

    public List<Person> input() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String str = scanner.nextLine();
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            str = str.replace(" ", "");
            if (!str.isEmpty()) {
                String[] cols = str.split(";");
                Person person = new Person(Integer.parseInt(cols[0]), cols[1], cols[2], new Department(cols[4]),
                        Integer.parseInt(cols[5]), cols[3]);
                result.add(person);
            }
        }
        scanner.close();
        return result;
    }
}
