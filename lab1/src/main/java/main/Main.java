package main;

import main.personEnv.LabFactory;
import main.personEnv.Repository;
import main.injector.Injector;
import main.reader.MyReader;
import main.reader.StreamApi;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Стартовый класс.
 */
public final class Main {

    /**
     * Конструктор.
     */
    private Main() {
    }

    /**
     * стартовый метод.
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyReader r = new MyReader();
        String way = "C:\\Users\\StasMalikov\\Desktop\\java\\JavaLabs\\lab1\\src\\main\\resources\\persons.csv";
        IRepository<IPerson> arr = r.parse(r.read(way));
//        for (int i = 0; i < ((Repository<IPerson>) arr).getLength(); i++) {
//            System.out.println(arr.get(i).toString());
//        }
        List<IPerson> list = arr.toList();
        List<IPerson> res = new ArrayList<>();
        for (IPerson i : list) {
            if (i != null) {
                res.add(i);
            }
        }

//        StreamApi.getMapDivisionAndTotalSalary(res).forEach((key, value) -> {
//            System.out.println("Division : " + key + " sum_salary : " + value);
//        });

//        StreamApi.getMapSortbyNameAndSalary2000(res).forEach((key, value) -> {
//            outputPerson((IPerson) value);
//            System.out.println(outputPerson((IPerson) value));
//        });

//        StreamApi.getMapSortByNameAA(res).forEach((key, value) -> {
//            outputPerson((IPerson) value);
//            System.out.println(outputPerson((IPerson) value));
//        });

        StreamApi.getMapSortByYearCount(res).forEach((key, value) -> {
            System.out.println("Date : " + key + " count_people : " + value);
        });


    }

    static String outputPerson(IPerson inpPr) {
        return String.format(" | ID " + inpPr.getId() + " | Имя " + inpPr.getFirstName() + ' ' + inpPr.getLastName() +
                " | ДР " + inpPr.getBirthdate().toString() + " | Возраст " + inpPr.getAge() + " | Пол " + inpPr.getGender() +
                " | Division " + inpPr.getDivision().getName() + ' ' + inpPr.getDivision().getId() + " | Salary " + inpPr.getSalary());
    }
}
