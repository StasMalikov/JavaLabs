package main;

import main.entities.enums.Gender;
import main.repository.IRepository;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyReader {

    /**
     * чтение из файла построчно.
     * @param fileName путь к фалйлу.
     * @return хранилище Person обьектов.
     */
    public IRepository read(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        IRepository repository = new PersonArr();

        for (int i = 1; i < lines.size(); i++) {
            String[] subStr;
            subStr = lines.get(i).split(";");
            repository.add(new Person(
                    Integer.parseInt(subStr[0]),
                    subStr[1],
                    "",
                    LocalDate.parse(subStr[3], DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.US)),
                    subStr[2].equals("Male") ? Gender.MALE : ( subStr[2].equals("Female") ? Gender.FEMALE : null),
                    new BigDecimal(subStr[5]),
                    ((PersonArr) repository).getDivision(subStr[4])
            ));
        }
        return repository;
    }
}
