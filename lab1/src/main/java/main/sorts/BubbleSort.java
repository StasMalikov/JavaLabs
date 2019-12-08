package main.sorts;

import java.util.Comparator;

/**
 * Класс сортировки пузырьком.
 */
public class BubbleSort<T> implements ISort<T>{

    /**
     *Сортировка, которая работает с экземпляром репозитория.
     */
//    public IRepository sort(final Comparator<IPerson> comparator,
//                            final IRepository arr) {
//        for (int i = 0; i < ((Repository) arr).getLength() - 1; i++) {
//           for (int j = 0; j < ((Repository) arr).getLength() - i - 2; j++) {
//               if (arr.get(j)  != null && arr.get(j + 1) != null) {
//                    if (comparator.compare(arr.get(j), arr.get(j + 1)) > 0) {
//                       IPerson tmp =  arr.get(j);
//                       arr.set(j, arr.get(j + 1));
//                       arr.set(j + 1, tmp);
//                    }
//               }
//           }
//        }
//       return arr;
//    }

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
        return arr;
    }
}
