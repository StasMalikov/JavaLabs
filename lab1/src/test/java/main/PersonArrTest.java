package main;

import main.entities.IPerson;
import main.entities.enums.Gender;
import main.repository.IRepository;
import org.junit.Assert;
import org.junit.Test;
import java.util.function.Predicate;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Predicate;

public class PersonArrTest {

    PersonArr arr;
    Person p1;
    Person p2;
    Person p3;
    Person p4;
    Person p5;

    public PersonArrTest() {
         p1 = new Person(1, "AAA", "",
                java.time.LocalDate.of(2015,11,30),
                Gender.FEMALE, new BigDecimal(1000), new Division("A"));
         p2 = new Person(1, "BBB", "",
                java.time.LocalDate.of(2016,9,27),
                Gender.MALE, new BigDecimal(1000), new Division("B"));
         p3 = new Person(1, "CCC", "",
                java.time.LocalDate.of(2017,9,27),
                Gender.FEMALE, new BigDecimal(1000), new Division("C"));
         p4 = new Person(1, "DDD", "",
                java.time.LocalDate.of(2018,12,27),
                Gender.MALE, new BigDecimal(1000), new Division("D"));
         p5 = new Person(1, "EEE", "",
                java.time.LocalDate.of(2019,11,11),
                Gender.FEMALE, new BigDecimal(1000), new Division("E"));

        arr = new PersonArr();
        arr.add(p1.clone());
        arr.add(p2.clone());
        arr.add(p3.clone());
        arr.add(p4.clone());
        arr.add(p5.clone());
    }

    @Test
    public void searchByName() {
        IRepository test = new PersonArr();
        test.add(p1);

        final Predicate<IPerson> isFirstName = new Predicate<IPerson>() {
            @Override
            public boolean test(IPerson n) {
                return "AAA".equals(n.getFirstName());
            }
        };
        PersonArr res = (PersonArr) arr.searchBy(isFirstName);
        Assert.assertEquals(test.get(0) ,res.get(0));
    }


    @Test
    public void add() {
        PersonArr test = new PersonArr();
        test.add(p1.clone());
        test.add(p2.clone());
        test.add(p3.clone());
        test.add(p4.clone());
        test.add(p5.clone());
        test.add( 2,p5);

        IRepository test2 = new PersonArr();
        test2.add(p1.clone());
        test2.add(p2.clone());
        test2.add(p5.clone());
        test2.add(p3.clone());
        test2.add(p4.clone());
        test2.add(p5.clone());

        for (int i = 0; i < ((PersonArr) test).getLength(); i++) {
            Assert.assertEquals(test.get(i) , test2.get(i));
        }
    }

    @Test
    public void delete() {
        PersonArr test = new PersonArr();
        test.add(p1.clone());
        test.add(p2.clone());
        test.add(p3.clone());
        test.add(p4.clone());
        test.add(p5.clone());

        test.delete(2);

        IRepository test2 = new PersonArr();
        test2.add(p1.clone());
        test2.add(p2.clone());
        test2.add(p4.clone());
        test2.add(p5.clone());

        for (int i = 0; i < test.getLength(); i++) {
            Assert.assertEquals(test.get(i) , test2.get(i));
        }
    }

        @Test
    public void insertionSortByName() {
        PersonArr actualArr = new PersonArr();
        actualArr.add(p5.clone());
        actualArr.add(p4.clone());
        actualArr.add(p3.clone());
        actualArr.add(p2.clone());
        actualArr.add(p1.clone());
        actualArr.sortBy(new FirstNameComporator());

        for (int i = 0; i < actualArr.getLength(); i++) {
            Assert.assertEquals(actualArr.get(i) , arr.get(i));
        }
    }

    @Test
    public void insertionSortByDate() {
        PersonArr actualArr = new PersonArr();
        actualArr.add(p5.clone());
        actualArr.add(p4.clone());
        actualArr.add(p3.clone());
        actualArr.add(p2.clone());
        actualArr.add(p1.clone());
        actualArr.sortBy(new BirthdateCopmorator());

        for (int i = 0; i < actualArr.getLength(); i++) {
            Assert.assertEquals(actualArr.get(i) , arr.get(i));
        }
    }

//    @Test
//    public void bubbleSortByName() {
//        PersonArr actualArr = new PersonArr();
//        Person p1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
//        Person p2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
//        Person p3 = new Person(3,"CCC", new LocalDate(2017,9,27), "female" );
//        Person p4 = new Person(4,"DDD", new LocalDate(2018,12,27), "male" );
//        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "female" );
//        actualArr.add(p5);
//        actualArr.add(p4);
//        actualArr.add(p3);
//        actualArr.add(p2);
//        actualArr.add(p1);
//        actualArr.bubbleSortByName();
//        for (int i = 0; i < arr.getLength(); i++) {
//            Assert.assertEquals(actualArr.getPerson(i) , arr.getPerson(i));
//        }
//    }

//    @Test
//    public void bubbleSortByBirthDate() {
//        PersonArr actualArr = new PersonArr();
//        Person p1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
//        Person p2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
//        Person p3 = new Person(3,"CCC", new LocalDate(2017,9,27), "female" );
//        Person p4 = new Person(4,"DDD", new LocalDate(2018,12,27), "male" );
//        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "female" );
//        actualArr.add(p5);
//        actualArr.add(p4);
//        actualArr.add(p3);
//        actualArr.add(p2);
//        actualArr.add(p1);
//        actualArr.bubbleSortByBirthDate();
//        for (int i = 0; i < arr.getLength(); i++) {
//            Assert.assertEquals(actualArr.getPerson(i) , arr.getPerson(i));
//        }
//    }


//    @Test
//    public void insertionSortByBirthDate() {
//        PersonArr actualArr = new PersonArr();
//        Person p1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
//        Person p2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
//        Person p3 = new Person(3,"CCC", new LocalDate(2017,9,27), "female" );
//        Person p4 = new Person(4,"DDD", new LocalDate(2018,12,27), "male" );
//        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "female" );
//        actualArr.add(p5);
//        actualArr.add(p4);
//        actualArr.add(p3);
//        actualArr.add(p2);
//        actualArr.add(p1);
//        actualArr.insertionSortByBirthDate();
//        for (int i = 0; i < arr.getLength(); i++) {
//            Assert.assertEquals(actualArr.getPerson(i) , arr.getPerson(i));
//        }
//    }
}