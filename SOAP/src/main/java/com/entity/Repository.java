package com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {

    private List<Human> humans;

    public Repository() {
        humans = new ArrayList<>();
        humans.add(new Human(1, "Louis", 20));
        humans.add(new Human(2, "Aidan ", 22));
        humans.add(new Human(3, "Mason ", 24));
        humans.add(new Human(4, "Scott ", 26));
        humans.add(new Human(5, "Rocco " , 28));
        humans.add(new Human(6, "Cassius " , 30));
    }

    public Human searchById(int id){
        List<Human> personsFilter = this.humans.stream().filter(human -> human.getId() == id)
                .collect(Collectors.toList());

        return personsFilter != null ? personsFilter.get(0) : null;
    }

    public List<Human> searchByAge(int age){
        List<Human> personsFilter= this.humans.stream().filter(human -> human.getAge() == age)
                .collect(Collectors.toList());
        return personsFilter;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }
}
