package main.injector;

import main.injector.LabInjector;
import ru.vsu.lab.repository.IRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Injector {
    public static <T> IRepository<T> inject(IRepository<T> repo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        for (Field field : repo.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(LabInjector.class)) {
                boolean isAccessible = field.canAccess(repo);
                field.setAccessible(true);
                field.set(repo, Class.forName(getSortName()).newInstance());
                field.setAccessible(isAccessible);
            }
        }
        return repo;
    }


    public static String getSortName() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/application.properties");
            property.load(fis);

            String sort = property.getProperty("sort");

            return sort;

        } catch (IOException e) {
            System.err.println("error loading properties");
        }
        return "error loading properties";
    }
}
