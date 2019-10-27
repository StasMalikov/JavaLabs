package main;

/**
 * Класс - репозиторий классов Person.
 */
public class PersonArr {

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
    public static final int INITLENGTH = 7;

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
     * @return текущий размер массива.
     */
    public int getLength() {
        return arr.length;
    }

    /**
     * @param index позиция нужного элемента в массиве.
     * @return элемент на позиции index.
     */
    public Person getPerson(final int index) {
        if (index < arr.length && index >= 0) {
            return arr[index];
        }
        return null;
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

}
