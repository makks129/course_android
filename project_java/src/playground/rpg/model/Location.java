package playground.rpg.model;

import playground.rpg.model.heros.Hero;

public class Location {

    private String name;
    private Hero[] heroes;

    public Hero[] getHeroes() {
        return heroes;
    }

    public void setHeroes(Hero[] heroes) {
        this.heroes = heroes;
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setLocation(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
