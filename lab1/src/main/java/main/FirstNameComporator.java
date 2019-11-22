package main;

import main.entities.IPerson;
import java.util.Comparator;

/**
 * компоратор сравненияя по имени.
 */
public class FirstNameComporator implements Comparator<IPerson> {

    /**
     * @return 0 если равны
     * @return 1 если p1 > p2
     * @return -1 если p1 < p2
     */
    @Override
    public int compare(final IPerson p1, final IPerson p2) {
//        if (p1.getFirstName().equals(p2.getFirstName())) {
//            return  0;
//        }
        return p1.getFirstName().compareTo(p2.getFirstName()) > 0 ?  1 : -1;
    }
}
