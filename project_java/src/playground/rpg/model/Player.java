package playground.rpg.model;

import playground.rpg.model.heros.Hero;

public class Player {

    private Hero hero;

    public Player(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
