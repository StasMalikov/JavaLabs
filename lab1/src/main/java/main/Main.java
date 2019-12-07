package main;

import main.personEnv.Repository;
import main.reader.MyReader;

import java.io.IOException;

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
        Repository arr = (Repository) r.parse(r.read(way));
        for (int i = 0; i < arr.getLength(); i++) {
            System.out.println(arr.get(i).toString());
        }
    }

}
