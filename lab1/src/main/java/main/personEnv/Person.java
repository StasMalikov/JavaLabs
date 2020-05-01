package main.personEnv;

import java.math.BigDecimal;
import java.util.Objects;
import java.time.LocalDate;

import org.apache.log4j.Logger;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

/**
 * Класс человека.
 */
public final class Person implements IPerson, Cloneable {

    private static final Logger log = Logger.getLogger(Person.class);

    /**
     * идентифицирующее поле.
     */
    private Integer id;

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
    private LocalDate birthdate;

    /**
     *пол человека.
     */
    private Gender gender;

    /**
     *разделение.
     */
    private IDivision division;

    /**
     * зарплата.
     */
    private BigDecimal salary;

    public Person() {
    }

    /**
     * Конструктор, заполняющий все поля класса.
     */
    public Person(final Integer id, final String firstName,
                  final String lastName,
                  final LocalDate birthdate, final Gender gender,
                  final BigDecimal salary, final IDivision division) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.salary = salary;
        this.division = division;
    }

    /**
     * Constructor.
     * @param person
     */
    public Person(final Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.birthdate = person.getBirthdate();
        this.gender = person.getGender();
        this.salary = person.getSalary();
        this.division = person.getDivision();
    }

    /**
     *@return зарплата.
     */
    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     *устанавливаем зарплату.
     */
    @Override
    public void setSalary(final BigDecimal salary) {
        this.salary = salary;
    }

    /**
     *возвращяем разделение.
     */
    @Override
    public IDivision getDivision() {
        return division;
    }

    /**
     *задаём разделение.
     */
    @Override
    public void setDivision(final IDivision division) {
        this.division = division;
    }

    /**
     *возвращяем фамилию.
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     *задаём фамилию.
     */
    @Override
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return имя.
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     *задаём имя.
     */
    @Override
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
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
     * @param birthdate дата дня рождения.
     */
    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return дата дня рождения.
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     *Вычисляет возраст человека на сегодняшний день.
     * @return количество лет.
     * Если день рождения определён в будущем том возвращяется значение -1.
     */
    public Integer getAge() {

        LocalDate now = LocalDate.now();

        if (now.getYear() < birthdate.getYear()
                || (now.getYear() == birthdate.getYear()
                && now.getDayOfYear() < birthdate.getDayOfYear())) {
            return -1;
        }
        log.info("getAge()");
        return now.getDayOfYear() >= birthdate.getDayOfYear()
                ? now.getYear() - birthdate.getYear() :
                now.getYear() - birthdate.getYear() - 1;

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

    /**
     * строка, составленная из полей класса.
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", gender=" + gender +
                ", division=" + division.getName() +
                ", salary=" + salary +
                '}';
    }

    /**
     * сравнение этого экземпляра класса и передаваемого в параметры.
     * @return результат сравнения.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        log.info("equals(final Object o)");
        return Objects.equals(getId(), person.getId()) &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getBirthdate(), person.getBirthdate()) &&
                getGender() == person.getGender() &&
                Objects.equals(getDivision(), person.getDivision()) &&
                Objects.equals(getSalary(), person.getSalary());
    }

    /**
     * @return вычесленный хэш код.
     */
    @Override
    public int hashCode() {
        log.info("hashCode()");
        return Objects.hash(getId(),
                getFirstName(), getLastName(),
                getBirthdate(), getGender(),
                getDivision(), getSalary());
    }

    /**
     * @return clone of this obj
     */
    public IPerson clone() {
        log.info("clone()");
        return new Person(id,
                firstName, lastName,
                birthdate, gender, salary, division);
    }
}
