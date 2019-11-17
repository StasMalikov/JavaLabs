package main;

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
        PersonArr arr = (PersonArr) r.read(way);
        System.out.println(arr.get(2).toString());
        System.out.println(arr.get(0).toString());
    }
}
