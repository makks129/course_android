package playground.rpg.model;

public class Boss extends Monster implements Lootable {

    public Boss(String name, int health, int mana) {
        super(name, health, mana);
    }

    @Override
    public Loot getLoot() {
        return new Loot();
    }

}
