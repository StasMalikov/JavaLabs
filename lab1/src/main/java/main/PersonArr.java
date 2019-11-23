package main;

import main.entities.IDivision;
import main.entities.IPerson;
import main.repository.IRepository;

import java.util.*;
import java.util.function.Predicate;

/**
 * Класс - репозиторий классов Person.
 */
public class PersonArr implements IRepository {

    /**
     * В этом поле хрантся экземпляры класс Person.
     */
    private IPerson[] arr;

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
    public PersonArr(final int arrLength) {
        if (arrLength > 0) {
            arr = new Person[arrLength];
        }
    }

    /**
     *конструктор по умолчанию.
     */
    public PersonArr() {
        arr = new Person[INITLENGTH];
        divisions = new ArrayList<>();
    }

    /**
     * @return количество ненулевых элементов массива.
     */
    public int getLength() {
        int i = 0;
        for (IPerson j : arr) {
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
        Division division = new Division(name);
        divisions.add(division);
        return division;
    }

    /**
     * приведение к списку.
     */
    public List<IPerson> toList() {
        return Arrays.asList(arr);
    }

    /**
     * @param index позиция нужного элемента в массиве.
     * @return элемент на позиции index.
     */
    public  IPerson get(final int index) {
        if (index < arr.length && index >= 0) {
            if ( arr[index] != null)
            return arr[index];
        }

        return null;
    }

    /**
     * изменяем элемент массива на позиции index.
     */
    public IPerson set(final int index, final IPerson person) {
        Person old = (Person) ((Person) arr[index]).clone();
        if (index < arr.length && index >= 0) {
            arr[index] = person;
        }
        return old;
    }

    /**
     * поиск по массиву.
     */
    public IRepository searchBy(final Predicate<IPerson> condition) {
        IRepository repository = new PersonArr();
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
    public void add(final IPerson person) {
        if (lastAddIndex + 1 < arr.length) {
            arr[++lastAddIndex] = person != null ? ((Person) person).clone() : null;
        } else {
            Person[] newArr =
                    new Person[(int) (arr.length
                            + arr.length * ARRSIZEINCREASEFACTOR)];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    newArr[i] = (Person) ((Person) arr[i]).clone();
                }
            }
            newArr[++lastAddIndex] = person != null ? (Person) ((Person) person).clone() : null;
            arr = newArr;
        }
    }

    /**
     *вставляем person на позицию index в массиве arr,
     *  по необходимости расширяем массив.
     */
    public void add(final int index, final IPerson person) {
        if (lastAddIndex + 1 < arr.length) {

            Person tmp = (Person) ((Person) arr[index]).clone();
            arr[index] = person;

            for (int i = index + 1; i < arr.length; i++) {
                Person tmp2 = arr[i] == null ?
                        null : (Person) ((Person) arr[i]).clone();
                arr[i] = tmp == null ? null : tmp.clone();
                tmp = tmp2 == null ? null : (Person) tmp2.clone();
                }

            } else {
                IPerson[] newArr =
                        new IPerson[(int) (arr.length
                                + arr.length * ARRSIZEINCREASEFACTOR)];
                for (int i = 0; i < index; i++) {
                    newArr[i] = arr[i];
                }

                Person tmp = (Person) ((Person) arr[index]).clone();
                newArr[index] = person;

                for (int i = index + 1; i < arr.length; i++) {
                    Person tmp2 = arr[i] == null ?
                            null : (Person) ((Person) arr[i]).clone();
                    newArr[i] = tmp == null ? null : tmp.clone();
                    tmp = tmp2 == null ? null : (Person) tmp2.clone();
                }
                lastAddIndex++;
                arr = newArr;
        }
    }

    /**
     * Удаляет из массива элемент на позиции index.
     * @param index позиция в массиве удаляемого элемента.
     */
    public IPerson delete(final int index) {
        IPerson delete_item = (Person) ((Person) arr[index]).clone();
        if (index < arr.length && index >= 0) {
            for (int i = index; i < lastAddIndex; i++) {
                arr[i] = ((Person) arr[i + 1]).clone();
            }
            arr[lastAddIndex--] = null;
        }
        return delete_item;
    }

    /**
     * сортировка вставками.
     */
	public void sortBy(final Comparator<IPerson> comparator) {
        BubbleSort b = new BubbleSort();
//        InsertionSort i = new InsertionSort();
        arr = b.sort(comparator, arr);
	}
}
