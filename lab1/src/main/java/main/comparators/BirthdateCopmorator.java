package main.comparators;
import org.apache.log4j.Logger;
import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

/**
 * компоратор для сравнения по дате.
 */
public class BirthdateCopmorator implements Comparator<IPerson> {

    private static final Logger log = Logger.getLogger(BirthdateCopmorator.class);

    /**
     * @return 0 если равны
     * @return 1 если p1 > p2
     * @return -1 если p1 < p2
     */
    @Override
    public int compare(final IPerson p1, final IPerson p2) {
        if (p1.getBirthdate() == p2.getBirthdate()) {
            return  0;
        }
        log.info("compare(final IPerson p1, final IPerson p2)");
        return p1.getBirthdate().isAfter(p2.getBirthdate()) ?  1 : -1;
    }
}
