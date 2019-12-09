package main;

import main.comparators.BirthdateCopmorator;
import main.personEnv.Division;
import main.personEnv.LabFactory;
import main.personEnv.Person;
import main.personEnv.Repository;
import main.injector.Injector;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Predicate;
import java.math.BigDecimal;

public class RepositoryTest {

    IRepository<IPerson> arr;
    IPerson p1;
    IPerson p2;
    IPerson p3;
    IPerson p4;
    IPerson p5;

    public RepositoryTest() throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
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
        LabFactory factory = new LabFactory();
        IPerson person = factory.createPerson();
        arr =  factory.createRepository((Class<IPerson>) person.getClass());
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);
        arr.add(p5);
    }

    @Test
    public void searchByNameDivision() {
        IRepository<IDivision> diviasions = new Repository<>();

        IDivision a = new Division("a");
        IDivision b = new Division("b");

        diviasions.add(a);
        diviasions.add(b);

        final Predicate<IDivision> isName = new Predicate<IDivision>() {
            @Override
            public boolean test(IDivision division) {
                return "a".equals(division.getName());
            }
        };
        IRepository<IDivision> res = diviasions.searchBy(isName);
        Assert.assertEquals(diviasions.get(0) ,res.get(0));
    }

    @Test
    public void searchByName() {
        IRepository test = new Repository();
        test.add(p1);

        final Predicate<IPerson> isFirstName = new Predicate<IPerson>() {
            @Override
            public boolean test(IPerson n) {
                return "AAA".equals(n.getFirstName());
            }
        };
        Repository res = (Repository) arr.searchBy(isFirstName);
        Assert.assertEquals(test.get(0) ,res.get(0));
    }

    @Test
    public void searchById() {
        IRepository test = new Repository();
        test.add(p1);

        final Predicate<IPerson> isId = new Predicate<IPerson>() {
            @Override
            public boolean test(IPerson p) {
                return 1 == p.getId();
            }
        };
        Repository res = (Repository) arr.searchBy(isId);
        Assert.assertEquals(test.get(0) ,res.get(0));
    }

    @Test
    public void add() {
        IRepository<IPerson> test = new Repository<>();
        test.add(((Person)p1).clone());
        test.add(((Person)p2).clone());
        test.add(((Person)p3).clone());
        test.add(((Person)p4).clone());
        test.add(((Person)p5).clone());
        test.add( 2,p5);

        IRepository<IPerson> test2 = new Repository<>();
        test2.add(((Person)p1).clone());
        test2.add(((Person)p2).clone());
        test2.add(((Person)p5).clone());
        test2.add(((Person)p3).clone());
        test2.add(((Person)p4).clone());
        test2.add(((Person)p5).clone());

        for (int i = 0; i < ((Repository) test).getLength(); i++) {
            Assert.assertEquals(test.get(i) , test2.get(i));
        }
    }

//    @Test
//    public void delete() {
//        Repository test = new Repository();
//        test.add(p1.clone());
//        test.add(p2.clone());
//        test.add(p3.clone());
//        test.add(p4.clone());
//        test.add(p5.clone());
//
//        test.delete(2);
//
//        IRepository test2 = new Repository();
//        test2.add(p1.clone());
//        test2.add(p2.clone());
//        test2.add(p4.clone());
//        test2.add(p5.clone());
//
//        for (int i = 0; i < test.getLength(); i++) {
//            Assert.assertEquals(test.get(i) , test2.get(i));
//        }
//    }

//        @Test
//    public void SortByName() {
//        Repository actualArr = new Repository();
//        actualArr.add(p5.clone());
//        actualArr.add(p4.clone());
//        actualArr.add(p3.clone());
//        actualArr.add(p2.clone());
//        actualArr.add(p1.clone());
//        actualArr.sortBy(new FirstNameComporator());
//
//        for (int i = 0; i < actualArr.getLength(); i++) {
//            Assert.assertEquals(actualArr.get(i) , arr.get(i));
//        }
//    }


    @Test
    public void SortByDate() throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        IRepository<IPerson> actualArr = new Repository<>();
        actualArr = Injector.inject(actualArr);
        actualArr.add(p5);
        actualArr.add(p4);
        actualArr.add(p3);
        actualArr.add(p2);
        actualArr.add(p1);
        actualArr.sortBy(new BirthdateCopmorator());

        for (int i = 0; i < ((Repository<IPerson>) actualArr).getLength(); i++) {
            Assert.assertEquals(actualArr.get(i) , arr.get(i));
        }
    }

}