package main;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PersonArrTest {

    PersonArr arr;

    public PersonArrTest() {
        Person p1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
        Person p2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
        Person p3 = new Person(3,"CCC", new LocalDate(2017,9,27), "female" );
        Person p4 = new Person(4,"DDD", new LocalDate(2018,12,27), "male" );
        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "female" );
        arr = new PersonArr();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);
        arr.add(p5);
    }

    @Test
    public void findFullName() {
        Person exp1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );

        Assert.assertEquals(Optional.of(exp1) , arr.find("AAA") );
        Assert.assertEquals(Optional.empty() , arr.find("AAA444") );
    }

    @Test
    public void findId() {
        Person exp1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );

        Assert.assertEquals(Optional.of(exp1) , arr.find(1) );
        Assert.assertEquals(Optional.empty() , arr.find(10) );
    }

    @Test
    public void findBirthDay() {
        Person exp1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );

        Assert.assertEquals(Optional.of(exp1) , arr.find(new LocalDate(2015,11,30)) );
        Assert.assertEquals(Optional.empty() , arr.find(new LocalDate(2020,11,30)) );
    }

    @Test
    public void findByGender() {
        Person exp1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
        Person exp2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
        Assert.assertEquals(Optional.of(exp1) , arr.findByGender("male") );
        Assert.assertEquals(Optional.of(exp2) , arr.findByGender("female") );
        Assert.assertEquals(Optional.empty() , arr.findByGender("null") );
    }

    @Test
    public void bubbleSortByName() {
        PersonArr actualArr = new PersonArr();
        Person p1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
        Person p2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
        Person p3 = new Person(3,"CCC", new LocalDate(2017,9,27), "female" );
        Person p4 = new Person(4,"DDD", new LocalDate(2018,12,27), "male" );
        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "female" );
        actualArr.add(p5);
        actualArr.add(p4);
        actualArr.add(p3);
        actualArr.add(p2);
        actualArr.add(p1);
        actualArr.bubbleSortByName();
        for (int i = 0; i < arr.getLength(); i++) {
            Assert.assertEquals(actualArr.getPerson(i) , arr.getPerson(i));
        }
    }

    @Test
    public void bubbleSortByBirthDate() {
        PersonArr actualArr = new PersonArr();
        Person p1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
        Person p2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
        Person p3 = new Person(3,"CCC", new LocalDate(2017,9,27), "female" );
        Person p4 = new Person(4,"DDD", new LocalDate(2018,12,27), "male" );
        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "female" );
        actualArr.add(p5);
        actualArr.add(p4);
        actualArr.add(p3);
        actualArr.add(p2);
        actualArr.add(p1);
        actualArr.bubbleSortByBirthDate();
        for (int i = 0; i < arr.getLength(); i++) {
            Assert.assertEquals(actualArr.getPerson(i) , arr.getPerson(i));
        }
    }

    @Test
    public void insertionSortByName() {
        PersonArr actualArr = new PersonArr();
        Person p1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
        Person p2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
        Person p3 = new Person(3,"CCC", new LocalDate(2017,9,27), "female" );
        Person p4 = new Person(4,"DDD", new LocalDate(2018,12,27), "male" );
        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "female" );
        actualArr.add(p5);
        actualArr.add(p4);
        actualArr.add(p3);
        actualArr.add(p2);
        actualArr.add(p1);
        actualArr.insertionSortByName();
        for (int i = 0; i < arr.getLength(); i++) {
            Assert.assertEquals(actualArr.getPerson(i) , arr.getPerson(i));
        }
    }

    @Test
    public void insertionSortByBirthDate() {
        PersonArr actualArr = new PersonArr();
        Person p1 = new Person(1,"AAA", new LocalDate(2015,11,30), "male" );
        Person p2 = new Person(2,"BBB", new LocalDate(2016,9,27), "female" );
        Person p3 = new Person(3,"CCC", new LocalDate(2017,9,27), "female" );
        Person p4 = new Person(4,"DDD", new LocalDate(2018,12,27), "male" );
        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "female" );
        actualArr.add(p5);
        actualArr.add(p4);
        actualArr.add(p3);
        actualArr.add(p2);
        actualArr.add(p1);
        actualArr.insertionSortByBirthDate();
        for (int i = 0; i < arr.getLength(); i++) {
            Assert.assertEquals(actualArr.getPerson(i) , arr.getPerson(i));
        }
    }
}