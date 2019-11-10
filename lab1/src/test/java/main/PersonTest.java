package main;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void getAge() {
        Person p1 = new Person(1,"AAA", new LocalDate(2019,11,30), "male" );
        Person p2 = new Person(2,"BBB", new LocalDate(2019,9,27), "male" );
        Person p3 = new Person(3,"CCC", new LocalDate(2010,9,27), "male" );
        Person p4 = new Person(4,"DDD", new LocalDate(2010,12,27), "male" );
        Person p5 = new Person(5,"EEE", new LocalDate(2019,11,11), "male" );

        Assert.assertEquals(-1, p1.getAge());
        Assert.assertEquals(0, p2.getAge());
        Assert.assertEquals(9, p3.getAge());
        Assert.assertEquals(8, p4.getAge());
        Assert.assertEquals(-1, p5.getAge());

    }
}