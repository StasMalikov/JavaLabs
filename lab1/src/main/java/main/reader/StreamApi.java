package main.reader;

import org.apache.log4j.Logger;
import ru.vsu.lab.entities.IPerson;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream api class.
 */
public class StreamApi {
    private static final Logger log = Logger.getLogger(StreamApi.class);
    /**
     * Map из названия департамента и суммы зарплат.
     * @param listPerson
     * @return
     */
    public  Map getMapDivisionAndTotalSalary(List<IPerson> listPerson) {  //Map<String, BigDecimal>
        Map<String, List<IPerson>> a1 = listPerson
                .stream()
                .collect(Collectors.groupingBy(p -> p.getDivision().getName() ));

        log.info("getMapDivisionAndTotalSalary is used");

        return a1.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        p -> p.getValue()
                                .stream()
                                .map(IPerson::getSalary).reduce(BigDecimal::add).get()));
    }

    /**
     *
     * @param listPerson
     * @return
     */
    public  Map getMapSortbyNameAndSalary2000(List<IPerson> listPerson) {  // Map<Integer, Person>
        log.info("getMapSortbyNameAndSalary2000 is used");
        return listPerson.stream()
                .filter(p -> p.getAge() > 30 &&
                        p.getFirstName().toLowerCase().contains("a") &&
                        p.getSalary().compareTo(new BigDecimal(2000)) < 0)
                .collect(Collectors.toMap(IPerson::getId,
                        p -> p));
    }

    /**
     *
     * @param listPerson
     * @return
     */
    public  Map getMapSortByNameAA(List<IPerson> listPerson) {  // Map<Integer, Person>
        log.info("getMapSortByNameAA is used");
        return listPerson.stream()
                .filter(p -> p.getFirstName().toLowerCase().contains("aa"))
                .collect(Collectors.toMap(IPerson::getId,
                        p -> p));
    }

    /**
     *
     * @param listPerson
     * @return
     */
    public  Map getMapSortByYearCount(List<IPerson> listPerson) { //Map<String, BigDecimal>
        log.info("getMapSortByYearCount is used");
        return listPerson
                .stream()
                .collect(Collectors.groupingBy(p->p.getBirthdate().getYear(), Collectors.counting()));
    }
}
