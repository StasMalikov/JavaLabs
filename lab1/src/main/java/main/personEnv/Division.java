package main.personEnv;


import ru.vsu.lab.entities.IDivision;

/**
 * Класс подразделения.
 */
public class Division implements IDivision {

    /**
     *Название.
     */
    private String name;

    /**
     *Идентификатор.
     */
    private Integer id;

    /**
     *Конструктор.
     */
    public Division(final  String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }
}
