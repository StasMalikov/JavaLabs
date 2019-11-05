package main;

import org.joda.time.LocalDate;

import java.util.Optional;

/**
 * Класс - репозиторий классов Person.
 */
public class PersonArr implements Collection {

    /**
     * В этом поле хрантся экземпляры класс Person.
     */
    private Person[] arr;

    /**
     * индекс последнего добаленного элемента.
     */
    private int lastAddIndex = -1;

    /**
     * Размер массива по умолчанию.
     */
    public static final int INITLENGTH = 5;

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
        for (Person j : arr) {
            if (j != null) {
                i++;
            }
        }
        return i;
    }

    /**
     * @param index позиция нужного элемента в массиве.
     * @return элемент на позиции index.
     */
    public  Optional<Person> getPerson(final int index) {
        if (index < arr.length && index >= 0) {
            return Optional.of(arr[index]);
        }

        return Optional.empty();
    }

    /**
     * Поиск в коллекции по артибуту.
     * @param fullName параметр по которому производится поиск (имя)
     * @return найденный или пустой экземпляр класса Optional
     */
    public Optional<Person> find(final String fullName) {
        for (Person i : arr) {
            if (i.getFullName() == fullName) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /**
     * Поиск в коллекции по артибуту.
     * @param id параметр по которому производится поиск (идентификатор)
     * @return найденный или пустой экземпляр класса Optional
     */
    public Optional<Person> find(final int id) {
        for (Person i : arr) {
            if (i.getId() == id) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /**
     * Поиск в коллекции по артибуту.
     * @param birthDay параметр по которому производится поиск (день рождениия)
     * @return найденный или пустой экземпляр класса Optional
     */
    public Optional<Person> find(final LocalDate birthDay) {
        for (Person i : arr) {
            if (i.getBirthDay() == birthDay) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /**
     * Поиск в коллекции по артибуту.
     * @param gender параметр по которому производится поиск (пол)
     * @return найденный или пустой экземпляр класса Optional
     */
    public Optional<Person> findByGender(final String gender) {
        for (Person i : arr) {
            if (i.getGender() == gender) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /**
     *Добавляет в массив элемент, по необходимоссти расширяет массив.
     * @param person добавлемый в массив элемент.
     */
    public void add(final Person person) {
        if (lastAddIndex + 1 < arr.length) {
            arr[++lastAddIndex] = new Person(person.getId(),
                    person.getFullName(), person.getBirthDay(),
                    person.getGender());
        } else {
            Person[] newArr = new Person[arr.length + INITLENGTH];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    newArr[i] = new Person(arr[i].getId(),
                            arr[i].getFullName(), arr[i].getBirthDay(),
                            arr[i].getGender());
                }
            }
            newArr[++lastAddIndex] = new Person(person.getId(),
                    person.getFullName(), person.getBirthDay(),
                    person.getGender());
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

                arr[i].setId(arr[i + 1].getId());
                arr[i].setFullName(arr[i + 1].getFullName());
                arr[i].setBirthDay(arr[i + 1].getBirthDay());
                arr[i].setGender(arr[i + 1].getGender());
            }
            arr[lastAddIndex--] = null;
        }
    }

    /**
     * сортировка пузырьком коллекции по имени в алфавитном порядке.
     */
    public void bubbleSortByName() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] != null && arr[j + 1] != null) {
                    if (arr[j].getFullName().compareTo(
                            arr[j + 1].getFullName()) > 0) {
                        Person tmp = arr[j].clone();
                        arr[j] = arr[j + 1].clone();
                        arr[j + 1] = tmp.clone();
                    }
                }
            }
        }
    }

    /**
     * сортировка пузырьком коллекции по дате рождения.
     * от ранней даты к поздней (20.10.10 ; 20.10.12 ; 20.10.15 )
     */
    public void bubbleSortByBirthDate() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] != null && arr[j + 1] != null) {
                    if (arr[j].getBirthDay().isAfter(
                            arr[j + 1].getBirthDay())) {
                        Person tmp = arr[j].clone();
                        arr[j] = arr[j + 1].clone();
                        arr[j + 1] = tmp.clone();
                    }
                }
            }
        }
    }

}
