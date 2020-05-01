package main.comparators;

import main.injector.Injector;
import org.apache.log4j.Logger;
import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

/**
 * компоратор сравненияя по имени.
 */
public class FirstNameComporator implements Comparator<IPerson> {

    private static final Logger log = Logger.getLogger(FirstNameComporator.class);

    /**
     * @return 0 если равны
     * @return 1 если p1 > p2
     * @return -1 если p1 < p2
     */
    @Override
    public int compare(final IPerson p1, final IPerson p2) {
        if (p1.getFirstName().equals(p2.getFirstName())) {
            return  0;
        }
        log.info("compare(final IPerson p1, final IPerson p2)");
        return p1.getFirstName().compareTo(p2.getFirstName()) > 0 ?  1 : -1;
    }
}
