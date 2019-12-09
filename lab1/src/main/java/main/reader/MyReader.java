package main.reader;

import main.personEnv.Division;
import main.personEnv.LabFactory;
import main.personEnv.Person;
import main.personEnv.Repository;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;
import java.util.function.Predicate;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *Класс для функций чтения из файлов.
 */
public class MyReader {

    public static final int IDINDEX = 0;
    public static final int FIRSTNAMEINDEX = 1;
    public static final int GENDERINDEX = 2;
    public static final int BIRTHDATEINDEX = 3;
    public static final int DIVISIONINDEX = 4;
    public static final int SALARYINDEX = 5;

    private IRepository<IDivision> divisions;

    public IRepository<IDivision> getDivisions() {
        return divisions;
    }
    /**
     * чтение из файла построчно.
     * @param fileName путь к фалйлу.
     * @return строчки файла.
     */
    public List<String> read(final String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    /**
     * Парсим список строк в репозотирой Person.
     */
    public IRepository<IPerson> parse(final List<String> lines) {
        LabFactory factory = new LabFactory();
        IPerson person = factory.createPerson();
        IRepository<IPerson> repository = factory.createRepository((Class<IPerson>) person.getClass());
        divisions = new Repository<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] subStr;
            subStr = lines.get(i).split(";");
            repository.add(new Person(
                    Integer.parseInt(subStr[IDINDEX]),
                    subStr[FIRSTNAMEINDEX],
                    "",
                    LocalDate.parse(subStr[BIRTHDATEINDEX], DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.US)),
                    subStr[GENDERINDEX].equals("Male") ? Gender.MALE :( subStr[2].equals("Female") ? Gender.FEMALE : null),
                    new BigDecimal(subStr[SALARYINDEX]),
                    divisions.searchBy(getPredicate(subStr[DIVISIONINDEX])).get(0) == null ?
                            ((Repository<IDivision>) divisions).addAndReturn(new Division(subStr[DIVISIONINDEX]))
                    :
                            divisions.searchBy(getPredicate(subStr[DIVISIONINDEX])).get(0)
            ));
        }
        return repository;
    }

    private Predicate<IDivision> getPredicate(final String name) {
       return new Predicate<IDivision>() {
            @Override
            public boolean test(IDivision division) {
                return name.equals(division.getName());
            }
        };
    }
}
