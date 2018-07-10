package playground.rpg.model.heros;

import playground.rpg.model.Npc;

public class Warrior extends Hero {
    public Warrior(String name, int health, int mana) {
        super(name, health, mana);
    }

    @Override
    public void dealDamage(Npc npc) {
        System.out.println("Warrior deals damage with a sword");
        npc.setHealth(npc.getHealth() - 50);
    }
}
