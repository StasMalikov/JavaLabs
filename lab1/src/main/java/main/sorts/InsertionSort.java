package main.sorts;

import java.util.Comparator;

/**
 * Класс сортировок вставками.
 */
public class InsertionSort<T> implements ISort<T>{

    /**
     *Сортировка, которая работает с экземпляром репозитория.
     */
//    public IRepository sort(final Comparator<IPerson> comparator,
//                            final IRepository arr) {
//        for (int left = 0; left < ((Repository) arr).getLength(); left++) {
//            Person value =  (Person) arr.get(left);
//            int i = left - 1;
//            for (; i >= 0; i--) {
//                if (comparator.compare(arr.get(i), value) > 0) {
//                    arr.set(i + 1, arr.get(i));
//                } else {
//                    break;
//                }
//            }
//            arr.set(i + 1, value);
//        }
//        return arr;
//    }

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
