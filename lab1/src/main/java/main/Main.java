package main;

import main.entities.IPerson;
import main.entities.enums.Gender;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        PersonArr arr = (PersonArr) r.parse(r.read(way));
        for (int i = 0; i < arr.getLength(); i++) {
            System.out.println(arr.get(i).toString());
        }
    }

}
