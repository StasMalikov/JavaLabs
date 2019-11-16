package main;
import main.entities.IDivision;
import main.entities.IPerson;
import main.entities.enums.Gender;
import java.math.BigDecimal;
import java.util.Objects;
import java.time.LocalDate;

/**
 * Класс человека.
 */
public final class Person implements IPerson, Cloneable {

    /**
     * идентифицирующее поле.
     */
    private Integer id;

    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public IDivision getDivision() {
        return division;
    }

    @Override
    public void setDivision(IDivision division) {
        this.division = division;
    }

    /**
     *имя человека.
     */
    private String firstName;

    /**
     *фамилия человека.
     */
    private String lastName;


    /**
     *дата дня рождения человека.
     */
    private LocalDate Birthdate;

    /**
     *пол человека.
     */
    private Gender gender;

    private IDivision division;

    private BigDecimal salary;

    /**
     * @param id идентификатор
     * @param Birthdate день рождения
     * @param gender пол
     */
    public Person(final Integer id, final String firstName, final String lastName,
                  final LocalDate Birthdate, final Gender gender,
                  final BigDecimal salary, IDivision division) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Birthdate = Birthdate;
        this.gender = gender;
        this.salary = salary;
        this.division = division;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return lastName;
    }

    @Override
    public void setFirstName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * @param id присваемый идентификатор.
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return идентификатор.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param Birthdate дата дня рождения.
     */
    public void setBirthdate(final LocalDate Birthdate) {
        this.Birthdate = Birthdate;
    }

    /**
     * @return дата дня рождения.
     */
    public LocalDate getBirthdate() {
        return Birthdate;
    }

    /**
     *Вычисляет возраст человека на сегодняшний день.
     * @return количество лет.
     * Если день рождения определён в будущем том возвращяется значение -1.
     */
    public Integer getAge() {

        LocalDate now = LocalDate.now();

        if (now.getYear() < Birthdate.getYear()
                || (now.getYear() == Birthdate.getYear()
                && now.getDayOfYear() < Birthdate.getDayOfYear())) {
            return -1;
        }

        return now.getDayOfYear() >= Birthdate.getDayOfYear()
                ? now.getYear() - Birthdate.getYear() : now.getYear() - Birthdate.getYear() - 1;
    }

    /**
     * @param gender пол человека.
     */
    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    /**
     * @return пол человека.
     */
    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Birthdate=" + Birthdate +
                ", gender=" + gender +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getBirthdate(), person.getBirthdate()) &&
                getGender() == person.getGender() &&
                Objects.equals(getDivision(), person.getDivision()) &&
                Objects.equals(getSalary(), person.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getBirthdate(), getGender(), getDivision(), getSalary());
    }

    /**
     * @return clone of this obj
     */
    public IPerson clone() {
        return new Person(id, firstName, lastName, Birthdate, gender, salary, division);
    }
}
