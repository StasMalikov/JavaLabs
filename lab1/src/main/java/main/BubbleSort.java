package main;

import main.entities.IPerson;
import main.repository.IRepository;
import java.util.Comparator;

/**
 * Класс сортировки пузырьком.
 */
public class BubbleSort {

    /**
     *Сортировка, которая работает с экземпляром репозитория.
     */
    public IRepository sort(final Comparator<IPerson> comparator,
                                                final IRepository arr) {
        for (int i = 0; i < ((PersonArr) arr).getLength() - 1; i++) {
           for (int j = 0; j < ((PersonArr) arr).getLength() - i - 2; j++) {
               if (arr.get(j)  != null && arr.get(j + 1) != null) {
                    if (comparator.compare(arr.get(j), arr.get(j + 1)) > 0) {
                       IPerson tmp =  arr.get(j);
                       arr.set(j, arr.get(j + 1));
                       arr.set(j + 1, tmp);
                    }
               }
           }
        }
       return arr;
    }

    /**
     *Сортировка, которая работает с массивом Person.
     */
    public IPerson[] sort(final Comparator<IPerson> comparator,
                                                 final IPerson[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] == null) {
                    continue;
                } else if (arr[j + 1] == null) {
                    arr[j + 1] = ((Person) arr[j]).clone();
                    arr[j] = null;
                } else {
                    if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                        IPerson tmp =  ((Person) arr[j]).clone();
                        arr[j] = ((Person) arr[j + 1]).clone();
                        arr[j + 1] = ((Person) tmp).clone();
                    }
                }
            }
        }
        return arr;
    }
}
