package main.sorts;

import java.util.Comparator;

public interface ISort<T> {
    public T[] sort(final Comparator<T> comparator, final T[] arr);
}
