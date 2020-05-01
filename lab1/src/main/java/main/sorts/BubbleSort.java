package main.sorts;

import main.reader.MyReader;
import org.apache.log4j.Logger;

import java.util.Comparator;

/**
 * Класс сортировки пузырьком.
 */
public class BubbleSort<T> implements ISort<T>{

    private static final Logger log = Logger.getLogger(BubbleSort.class);

    /**
     *Сортировка, которая работает с массивом Person.
     */
    public T[] sort(final Comparator<T> comparator, final T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] != null && arr[j + 1] != null) {
                    if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                        T tmp =   arr[j];
                        arr[j] =  arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }
        }
        log.info("Array is sorted by BubbleSort");
        return arr;
    }
}
