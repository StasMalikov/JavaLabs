package main;

import main.Person;
import main.entities.IPerson;
import java.util.Comparator;


public class FirstNameComporator implements Comparator<IPerson> {

    /**
     * @return 0 если равны
     * @return 1 если p1 > p2
     * @return -1 если p1 < p2
     */
    @Override
    public int compare(IPerson p1, IPerson p2) {
        if (p1.getFirstName() == p2.getFirstName()) {
            return  0;
        }
        return p1.getFirstName().compareTo(p2.getFirstName()) > 0 ?  1 : -1;
    }
}
