package main;
import  org.joda.time.LocalDate;
import java.util.Objects;

/**
 * Класс человека.
 */
public final class Person {

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
     *
     * @param id идентификатор
     * @param fullName полное имя (ФИО)
     * @param birthDay день рождения
     * @param gender пол
     */
    public Person(final int id, final String fullName, final LocalDate birthDay, final String gender) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public int getAge(){

        LocalDate now = LocalDate.now();

        if (now.getYear() < birthDay.getYear() || (now.getYear() >= birthDay.getYear() && now.getDayOfYear() < birthDay.getDayOfYear()))
            return -1;

        if(now.getMonthOfYear() >= birthDay.getMonthOfYear() && now.getDayOfMonth() >= birthDay.getDayOfMonth())
            return now.getYear() - birthDay.getYear();

        return now.getYear() - birthDay.getYear() - 1 >=0 ? now.getYear() - birthDay.getYear() - 1 : 0;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                Objects.equals(getFullName(), person.getFullName()) &&
                Objects.equals(getBirthDay(), person.getBirthDay()) &&
                Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getBirthDay(), getGender());
    }
}
