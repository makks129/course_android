package playground.rpg.model.heros;

import playground.rpg.model.Loot;
import playground.rpg.model.Lootable;
import playground.rpg.model.Npc;

public abstract class Hero extends Npc implements Lootable {

    private String fraction;

    public Hero(String name, int health, int mana) {
        super(name, health, mana);
    }

    @Override
    public Loot getLoot() {
        return new Loot();
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }
}
