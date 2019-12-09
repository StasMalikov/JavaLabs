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
        Map<String, List<IPerson>> res = StreamApi.getMapDivisionAndTotalSalary(arr.toList());

        for (Map.Entry<String, List<IPerson>> item : res.entrySet()) {
            System.out.println(item.getKey());
        }
    }
}
