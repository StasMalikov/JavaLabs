package main.injector;

import main.reader.MyReader;
import ru.vsu.lab.repository.IRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Класс подключения зависимостей.
 */
public class Injector {

    /**
     *Конструктор класса.
     */
    public Injector() {}

    /**
     * Медод, подключающий сортировку по свойству из файла.
     */
    public static <T> T inject(T repo) throws MyExeption {
        try {

            List<List<String>> arr = getSortName();
           for (Field field : repo.getClass().getDeclaredFields()) {
               if (field.isAnnotationPresent(LabInjector.class)) {
                   for(List<String> i : arr) {
                       if (field.getType().getName().equals(i.get(0))) {
                           boolean isAccessible = field.canAccess(repo);
                           field.setAccessible(true);
                           field.set(repo, Class.forName(i.get(1)).newInstance());
                           field.setAccessible(isAccessible);
                       }
                   }
               }
           }
           return repo;
       } catch (Exception e) {
            new MyExeption(e.toString());
       }
            return null;
        }


    /**
     *Метод, читающий файл со свойсствами.
     */
    public static List<List<String>> getSortName() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream(
                    "src/main/resources/application.properties");
            property.load(fis);

            Enumeration<?> e =  property.propertyNames();
            List<List<String>> list = new ArrayList<>();
            int i = 0;
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                list.add(new ArrayList<String>());
                list.get(i).add(key);
                list.get(i).add(property.getProperty(key));
                        i++;
            }

            return list;

        } catch (Exception e) {
            new MyExeption(e.toString());
        }

        return null;
    }
}
