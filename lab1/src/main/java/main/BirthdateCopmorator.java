package main;
import main.Person;
import main.entities.IPerson;
import java.util.Comparator;

public class BirthdateCopmorator implements Comparator<IPerson> {
    /**
     * @return 0 если равны
     * @return 1 если p1 > p2
     * @return -1 если p1 < p2
     */
    @Override
    public int compare(IPerson p1, IPerson p2) {
        if (p1.getBirthdate() == p2.getBirthdate()) {
            return  0;
        }
        return p1.getBirthdate().isAfter(p2.getBirthdate()) ?  1 : -1;
    }
}
