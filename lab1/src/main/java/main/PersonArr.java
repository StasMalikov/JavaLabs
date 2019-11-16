package main;

import main.entities.IPerson;
import main.repository.IRepository;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Класс - репозиторий классов Person.
 */
public class PersonArr implements IRepository {

    /**
     * В этом поле хрантся экземпляры класс Person.
     */
    private IPerson[] arr;

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
     * приведение к списку.
     */
    public List<IPerson> toList() {
        return Arrays.asList(arr);
    }

    /**
     * @param index позиция нужного элемента в массиве.
     * @return элемент на позиции index.
     */
    public  Optional<IPerson> get(final int index) {
        if (index < arr.length && index >= 0) {
            return Optional.of(arr[index]);
        }

        return Optional.empty();
    }

    /**
     * изменяем элемент массива на позиции index.
     */
    public void set(final int index, final IPerson person) {
        if (index < arr.length && index >= 0) {
            arr[index] = person;
        }
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
            arr[++lastAddIndex] = ((Person) person).clone();
        } else {
            Person[] newArr =
                    new Person[(int) (arr.length
                            + arr.length * ARRSIZEINCREASEFACTOR)];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    newArr[i] = (Person) ((Person) arr[i]).clone();
                }
            }
            newArr[++lastAddIndex] = (Person) ((Person) person).clone();
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

                for (int i = index + 1; i < arr.length + 1; i++) {
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
    public void delete(final int index) {
        if (index < arr.length && index >= 0) {

            for (int i = index; i < lastAddIndex; i++) {
                arr[i] = ((Person) arr[i + 1]).clone();
            }
            arr[lastAddIndex--] = null;
        }
    }

    /**
     * сортировка пузырьком коллекции.
     */
    public void bubbleSortBy(final Comparator<IPerson> comparator) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] != null && arr[j + 1] != null) {
                    if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                        Person tmp = (Person) ((Person) arr[j]).clone();
                        arr[j] = ((Person) arr[j + 1]).clone();
                        arr[j + 1] = tmp.clone();
                    }
                }
            }
        }
    }

    /**
     * сортировка вставками.
     */
	public void sortBy(final Comparator<IPerson> comparator) {
		for (int left = 0; left < this.getLength(); left++) {
			Person value = (Person) ((Person) arr[left]).clone();
            int i = left - 1;
            for (; i >= 0; i--) {
                if (comparator.compare(arr[i], value) > 0) {
                    arr[i + 1] = ((Person) arr[i]).clone();
                } else {
                    break;
                }
            }
            arr[i + 1] = value.clone();
		}
	}
}
