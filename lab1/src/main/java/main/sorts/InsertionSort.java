package main.sorts;

import org.apache.log4j.Logger;

import java.util.Comparator;

/**
 * Класс сортировок вставками.
 */
public class InsertionSort<T> implements ISort<T>{

    private static final Logger log = Logger.getLogger(InsertionSort.class);

    /**
     *Сортировка, которая работает с массивом Person.
     */
    public T[] sort(final Comparator<T> comparator, final T[] arr) {
        for (int left = 0; left < arr.length; left++) {
            T value =   arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (comparator.compare(arr[i], value) > 0) {
                    arr[i + 1] =  arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }

        log.info("Array is sorted by BubbleSort");
        return arr;
    }
}
