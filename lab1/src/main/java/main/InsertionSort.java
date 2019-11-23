package main;

import main.entities.IPerson;
import main.repository.IRepository;

import java.util.Comparator;

/**
 * Класс сортировок вставками.
 */
public class InsertionSort {

    /**
     *Сортировка, которая работает с экземпляром репозитория.
     */
    public IRepository sort(final Comparator<IPerson> comparator,
                                                final IRepository arr) {
        for (int left = 0; left < ((PersonArr) arr).getLength(); left++) {
            Person value =  (Person) arr.get(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (comparator.compare(arr.get(i), value) > 0) {
                    arr.set(i + 1, arr.get(i));
                } else {
                    break;
                }
            }
            arr.set(i + 1, value);
        }
        return arr;
    }

    /**
     *Сортировка, которая работает с массивом Person.
     */
    public IPerson[] sort(final Comparator<IPerson> comparator,
                                                final IPerson[] arr) {
        for (int left = 0; left < arr.length; left++) {
            IPerson value =  (Person) arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (comparator.compare(arr[i], value) > 0) {
                    arr[i + 1] = ((Person) arr[i]).clone();
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
        return arr;
    }
}
