package main;
import org.joda.time.LocalDate;

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
    public static void main(final String[] args) {
       Person a1 = new Person(1,"Sasha",new LocalDate(2019,9,27),"male");
       Person a2 = new Person(2,"Misha",new LocalDate(2010,9,27),"male");
       Person a3 = new Person(3,"Masha",new LocalDate(2009,9,27),"female");
       PersonArr arr =new PersonArr(3);
       arr.add(a1);
       arr.add(a2);
       arr.add(a3);

       arr.bubbleSortByBirthDate();

       for (int i = 0; i < arr.getLength(); i++){
           System.out.println(arr.getPerson(i).toString());
        }

//       arr.delete(0);
//       System.out.println("----------");
//      arr.add(a1);
//
//      for (int i = 0; i < arr.getLength(); i++){
//           System.out.println(arr.getPerson(i).toString());
//       }
    }
}
