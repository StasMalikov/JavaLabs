package main.reader;

import ru.vsu.lab.entities.IPerson;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {

    public static Map getMapDivisionAndTotalSalary(List<IPerson> listPerson) {  //Map<String, BigDecimal>
        Map<String, List<IPerson>> a1 = listPerson
                .stream()
                .collect(Collectors.groupingBy(p -> p.getDivision().getName() ));

        return a1;
//        return a1.entrySet()
//                .stream()
//                .collect(Collectors.toMap(Map.Entry::getKey,
//                        p -> p.getValue()
//                                .stream()
//                                .map(IPerson::getSalary).reduce(BigDecimal::add).get()));
    }
}
