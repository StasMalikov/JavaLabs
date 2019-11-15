package main;

import main.entities.IPerson;
import main.entities.enums.Gender;
import main.repository.IRepository;

import java.time.LocalDate;
import java.util.Optional;

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
     * @param index позиция нужного элемента в массиве.
     * @return элемент на позиции index.
     */
    public  Optional<IPerson> get(final int index) {
        if (index < arr.length && index >= 0) {
            return Optional.of(arr[index]);
        }

        return Optional.empty();
    }

    public void set(int index, IPerson person) {
        if (index < arr.length && index >= 0) {
            arr[index] = person;
        }
    }

    /**
     * Поиск в коллекции по артибуту.
     * @param firstName параметр по которому производится поиск (имя)
     * @return найденный или пустой экземпляр класса Optional
     */
    public Optional<IPerson> find(final String firstName) {
        for (IPerson i : arr) {
            if (i.getFirstName() == firstName) {
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
    public Optional<IPerson> find(final int id) {
        for (IPerson i : arr) {
            if (i.getId() == id) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /**
     * Поиск в коллекции по артибуту.
     * @param birthDate параметр по которому производится поиск (день рождениия)
     * @return найденный или пустой экземпляр класса Optional
     */
    public Optional<IPerson> find(final LocalDate birthDate) {
        for (IPerson i : arr) {
            if (i.getBirthdate().compareTo(birthDate) == 0) {
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
    public Optional<IPerson> findByGender(final Gender gender) {
        for (IPerson i : arr) {
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
    public void add(final IPerson person) {
        if (lastAddIndex + 1 < arr.length) {
            arr[++lastAddIndex] = new Person(person.getId(),
                    person.getFirstName(), person.getLastName(),
                    person.getBirthdate(), person.getGender());
        } else {
            Person[] newArr = new Person[arr.length + INITLENGTH];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    newArr[i] = new Person(arr[i].getId(),
                            arr[i].getFirstName(), arr[i].getFirstName(),
                            arr[i].getBirthdate(), arr[i].getGender());
                }
            }
            newArr[++lastAddIndex] = new Person(person.getId(),
                    person.getFirstName(), person.getLastName(),
                    person.getBirthdate(), person.getGender());
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
                arr[i] = ((Person)arr[i + 1]).clone();
            }
            arr[lastAddIndex--] = null;
        }
    }

    /**
     * сортировка пузырьком коллекции по имени в алфавитном порядке.
     */
    public void bubbleSortByFirstName() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] != null && arr[j + 1] != null) {
                    if (arr[j].getFirstName().compareTo(
                            arr[j + 1].getFirstName()) > 0) {
                        Person tmp = (Person)((Person)arr[j]).clone();
                        arr[j] = ((Person)arr[j + 1]).clone();
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
                    if (arr[j].getBirthdate().isAfter(
                            arr[j + 1].getBirthdate())) {
                        Person tmp = (Person)((Person)arr[j]).clone();
                        arr[j] = ((Person)arr[j + 1]).clone();
                        arr[j + 1] = tmp.clone();
                    }
                }
            }
        }
    }
	
	public void insertionSortByFirstName() {
		for (int left = 0; left < this.getLength(); left++) {
			Person value = (Person)((Person)arr[left]).clone();
            int i = left - 1;
            for (; i >= 0; i--) {
                if (arr[i].getFirstName().compareTo(value.getFirstName()) > 0) {
                    arr[i + 1] = ((Person)arr[i]).clone();
                } else {
                    break;
                }
            }
            arr[i + 1] = value.clone();
		}
	}

	public void insertionSortByBirthDate() {
        for (int left = 0; left < this.getLength(); left++) {
            Person value = (Person)((Person)arr[left]).clone();
            int i = left - 1;
            for (; i >= 0; i--) {
                if (arr[i].getBirthdate().isAfter(value.getBirthdate())) {
                    arr[i + 1] = ((Person)arr[i]).clone();
                } else {
                    break;
                }
            }
            arr[i + 1] = value.clone();
        }
    }

}
