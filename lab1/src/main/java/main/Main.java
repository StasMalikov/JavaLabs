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
//        MyReader r = new MyReader();
//        String way = "C:\\Users\\StasMalikov\\Desktop\\java\\JavaLabs\\lab1\\src\\main\\resources\\persons.csv";
//        PersonArr arr = (PersonArr) r.read(way);
//        for (int i = 0; i < arr.getLength(); i++) {
//            System.out.println(arr.get(i).toString());
//        }

//     Person   p1 = new Person(1, "AAA", "",
//                java.time.LocalDate.of(2015,11,30),
//                Gender.FEMALE, new BigDecimal(1000), new Division("A"));
//        Person   p2 = new Person(1, "BBB", "",
//                java.time.LocalDate.of(2016,9,27),
//                Gender.MALE, new BigDecimal(1000), new Division("B"));
//        Person   p3 = new Person(1, "CCC", "",
//                java.time.LocalDate.of(2017,9,27),
//                Gender.FEMALE, new BigDecimal(1000), new Division("C"));
//        Person   p4 = new Person(1, "DDD", "",
//                java.time.LocalDate.of(2018,12,27),
//                Gender.MALE, new BigDecimal(1000), new Division("D"));
//        Person   p5 = new Person(1, "EEE", "",
//                java.time.LocalDate.of(2019,11,11),
//                Gender.FEMALE, new BigDecimal(1000), new Division("E"));

//       PersonArr arr = new PersonArr();
//        arr.add(p1.clone());
//        arr.add(p2.clone());
//        arr.add(p3.clone());
//        arr.add(p4.clone());
//        arr.add(p5.clone());
//
//        PersonArr actualArr = new PersonArr();
//        actualArr.add(p5.clone());
//        actualArr.add(p4.clone());
//        actualArr.add(p3.clone());
//        actualArr.add(p2.clone());
//        actualArr.add(p1.clone());
//        actualArr.sortBy(new FirstNameComporator());

//        for (int i = 0; i < actualArr.getLength(); i++) {
//            Assert.assertEquals(actualArr.get(i) , arr.get(i));
//        }

        String[] arr = new String[5];
        arr[0]= "EEE";
        arr[1]= "DDD";
        arr[2]= "CCC";
        arr[3]= "BBB";
        arr[4]= "AAA";
       IPerson p1 = new Person(1, "a", "",
                java.time.LocalDate.of(2015,11,30),
                Gender.FEMALE, new BigDecimal(1000), new Division("A"));
        IPerson p2 = new Person(1, "b", "",
                java.time.LocalDate.of(2016,9,27),
                Gender.MALE, new BigDecimal(1000), new Division("B"));
        String a = p1.getFirstName();
        String b = p2.getFirstName();
        System.out.println(b.compareTo(a));
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//        System.out.println("----");
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 2; j++) {
//                if (arr[j].compareTo(arr[j + 1]) > 0 ) {
//                    String tmp = arr[j];
//                    arr[j].replace(arr[j],arr[j + 1]);
//                    arr[j + 1].replace(arr[j + 1], tmp);
//                }
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

    }

}
