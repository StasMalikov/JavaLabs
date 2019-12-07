package main.personEnv;

import main.sorts.BubbleSort;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.util.*;
import java.util.function.Predicate;

/**
 * Класс - репозиторий классов Person.
 */
public class Repository<T> implements IRepository<T> {

    /**
     * В этом поле хрантся экземпляры класс Person.
     */
    private T[] arr;

    private List<IDivision> divisions;

    /**
     * индекс последнего добаленного элемента.
     */
    private int lastAddIndex = -1;

    /**
     * Размер массива по умолчанию.
     */
    public static final int INITLENGTH = 5;

    /**
     * константа на которую увеличивается размер массива.
     */
    public static final double ARRSIZEINCREASEFACTOR = 1.5;

    /**
     * @param arrLength размер создаваемого массива.
     */
    public Repository(final int arrLength) {
        if (arrLength > 0) {
            arr = (T[])(new Object[arrLength]);
        }
    }

    /**
     *конструктор по умолчанию.
     */
    public Repository() {
        arr = (T[])(new Object[INITLENGTH]);
        divisions = new ArrayList<>();
    }

    /**
     * @return количество ненулевых элементов массива.
     */
    public int getLength() {
        int i = 0;
        for (T j : arr) {
            if (j != null) {
                i++;
            }
        }
        return i;
    }

    /**
     * Ищет в списке подразделений по имени,
     * если не находит, то создаёт новое.
     */
    public IDivision getDivision(String name) {
        for (IDivision i : divisions) {
            if (i.getName().equals(name)) {
                return i;
            }
        }

        IDivision division = new Division(name);
        divisions.add(division);
        return division;
    }

    /**
     * приведение к списку.
     */
    public List<T> toList() {
        return Arrays.asList(arr);
    }

    /**
     * @param index позиция нужного элемента в массиве.
     * @return элемент на позиции index.
     */
    public T get(final int index) {
        if (index < arr.length && index >= 0) {
            if ( arr[index] != null)
            return arr[index];
        }

        return null;
    }

    /**
     * изменяем элемент массива на позиции index.
     */
    public T set(final int index, final Object person) {

        if (index < arr.length && index >= 0) {
            T old = (T) arr[index];
            arr[index] = (T) person;
            return old;
        }
        return null;
    }

    /**
     * поиск по массиву.
     * @param condition
     */
    public IRepository<T> searchBy(final Predicate<T> condition) {
        IRepository repository = new Repository();
        for (int i = 0; i < arr.length; i++) {
            if (condition.test(arr[i])) {
                repository.add(arr[i]);
            }
        }
        return repository;
    }

    /**
     *Добавляет в массив элемент, по необходимоссти расширяет массив.
     * @param person добавлемый в массив элемент.
     */
    public void add(final T person) {
        if (lastAddIndex + 1 < arr.length) {
            arr[++lastAddIndex] = person != null ? person : null;
        } else {
            T[] newArr =
                    (T[]) new Object[(int) (arr.length
                            + arr.length * ARRSIZEINCREASEFACTOR)];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    newArr[i] =  arr[i];
                }
            }
            newArr[++lastAddIndex] = person != null ?  person : null;
            arr = newArr;
        }
    }

    /**
     *вставляем person на позицию index в массиве arr,
     *  по необходимости расширяем массив.
     */
    public void add(final int index, final Object person) {
        if (lastAddIndex + 1 < arr.length) {

            T tmp =  arr[index];
            arr[index] = (T) person;

            for (int i = index + 1; i < arr.length; i++) {
                T tmp2 = arr[i] == null ? null : arr[i];
                arr[i] = tmp == null ? null : tmp;
                tmp = tmp2 == null ? null :  tmp2;
                }

            } else {
                T[] newArr =
                        (T[])new Object[(int) (arr.length
                                + arr.length * ARRSIZEINCREASEFACTOR)];
                for (int i = 0; i < index; i++) {
                    newArr[i] = arr[i];
                }

                T tmp = arr[index];
                newArr[index] = (T) person;

                for (int i = index + 1; i < arr.length; i++) {
                    T tmp2 = arr[i] == null ? null : arr[i];
                    newArr[i] = tmp == null ? null : tmp;
                    tmp = tmp2 == null ? null :  tmp2;
                }
                lastAddIndex++;
                arr = newArr;
        }
    }

    /**
     * Удаляет из массива элемент на позиции index.
     * @param index позиция в массиве удаляемого элемента.
     */
    public T delete(final int index) {

        if (index < arr.length && index >= 0) {
            T delete_item =  arr[index];
            for (int i = index; i < lastAddIndex; i++) {
                arr[i] = arr[i + 1];
            }
            arr[lastAddIndex--] = null;
            return delete_item;
        }
        return null;
    }

    /**
     * сортировка вставками.
     * @param comparator
     */
	public void sortBy(final Comparator<T> comparator) {
        BubbleSort b = new BubbleSort();
//        InsertionSort i = new InsertionSort();
//        arr = b.sort(comparator, arr);
	}
}
