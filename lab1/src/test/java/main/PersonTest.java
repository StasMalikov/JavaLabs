package main;

import main.entities.enums.Gender;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonTest {

    @Test
    public void getAge() {
        Person p1 = new Person(1, "AAA", "",
               LocalDate.of(2020,11,11),
                Gender.FEMALE, new BigDecimal(1000), new Division("A"));

        Person p2 = new Person(1, "AAA", "",
                LocalDate.of(2019,11,11),
                Gender.FEMALE, new BigDecimal(1000), new Division("A"));

        Person p3 = new Person(1, "AAA", "",
                LocalDate.of(2010,11,11),
                Gender.FEMALE, new BigDecimal(1000), new Division("A"));


        Assert.assertEquals(-1,(int) p1.getAge());
        Assert.assertEquals(0, (int) p2.getAge());
        Assert.assertEquals(9, (int) p3.getAge());
    }
}