package main.sorts;

import java.util.Comparator;

/**
 * Класс сортировок вставками.
 */
public class InsertionSort<T> implements ISort<T>{

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
        return arr;
    }
}
