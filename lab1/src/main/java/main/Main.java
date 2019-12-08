package main;

import main.personEnv.Division;
import main.personEnv.Repository;
import main.reader.MyReader;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;
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
    public static void main(final String[] args) throws IOException {

        MyReader r = new MyReader();
        String way = "C:\\Users\\StasMalikov\\Desktop\\java\\JavaLabs\\lab1\\src\\main\\resources\\persons.csv";
        IRepository<IPerson> arr = r.parse(r.read(way));
        for (int i = 0; i < ((Repository<IPerson>) arr).getLength(); i++) {
            System.out.println(arr.get(i).toString());
        }
    }

}
