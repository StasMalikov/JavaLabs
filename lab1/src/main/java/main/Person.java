package main;
import  org.joda.time.LocalDate;
import java.util.Objects;

/**
 * Класс человека.
 */
public final class Person implements Cloneable {

    /**
     * идентифицирующее поле.
     */
    private int id;

    /**
     *полное имя человека.
     */
    private String fullName;

    /**
     *дата дня рождения человека.
     */
    private LocalDate birthDay;

    /**
     *пол человека.
     */
    private String gender;

    /**
     * @param id идентификатор
     * @param fullName полное имя (ФИО)
     * @param birthDay день рождения
     * @param gender пол
     */
    public Person(final int id, final String fullName,
                  final LocalDate birthDay, final String gender) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    /**
     * @param id присваемый идентификатор.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return идентификатор.
     */
    public int getId() {
        return id;
    }

    /**
     * @param fullName полное имя.
     */
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return полное имя.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param birthDay дата дня рождения.
     */
    public void setBirthDay(final LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * @return дата дня рождения.
     */
    public LocalDate getBirthDay() {
        return birthDay;
    }

    /**
     *Вычисляет возраст человека на сегодняшний день.
     * @return количество лет.
     * Если день рождения определён в будущем том возвращяется значение -1.
     */
    public int getAge() {

        LocalDate now = LocalDate.now();

        if (now.getYear() < birthDay.getYear()
                || (now.getYear() >= birthDay.getYear()
                && now.getDayOfYear() < birthDay.getDayOfYear())) {
            return -1;
        }

        if (now.getMonthOfYear() >= birthDay.getMonthOfYear()
                && now.getDayOfMonth() >= birthDay.getDayOfMonth()) {
            return now.getYear() - birthDay.getYear();
        }

        return now.getYear() - birthDay.getYear() - 1 >= 0
                ? now.getYear() - birthDay.getYear() - 1 : 0;
    }

    /**
     * @param gender пол человека.
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     * @return пол человека.
     */
    public String getGender() {
        return gender;
    }

    /**
     *Сгенерированный метод приведения класса к строке.
     * @return класс в виде строки.
     */
    @Override
    public String toString() {
        return "Person{" + "id="
                + id
                + ", fullName='"
                + fullName
                + '\''
                + ", birthDay="
                + birthDay
                + ", gender='"
                + gender
                + '\''
                + '}';
    }

    /**
     *Сгенерированный метод сравнения двух экземпляров классов.
     * @param o обьект сравнения.
     * @return результат сравнения.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return getId() == person.getId()
                && Objects.equals(getFullName(), person.getFullName())
                && Objects.equals(getBirthDay(), person.getBirthDay())
                && Objects.equals(getGender(), person.getGender());
    }

    /**
     * Сгенерированный метод вычисления хэша класса.
     * @return вычисленный хэш.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getBirthDay(), getGender());
    }

    /**
     * @return clone of this obj
     */
    public Person clone() {
        return new Person(id, fullName, birthDay, gender);
    }
}
