package main;

import main.injector.LabInjector;
import main.personEnv.Division;
import main.personEnv.Repository;
import main.reader.InjectUtils;
import main.reader.MyReader;
import main.sorts.ISort;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.function.Predicate;

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
        arr = InjectUtils.inject(arr);
        int y = 0;
        for (int i = 0; i < ((Repository<IPerson>) arr).getLength(); i++) {
            System.out.println(arr.get(i).toString());
        }
        System.out.println();
    }
}
