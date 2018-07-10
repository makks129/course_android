package playground.rpg.model.heros;

import playground.rpg.model.Npc;

public class Mage extends Hero {

    public Mage(String name, int health, int mana) {
        super(name, health, mana);
    }

    @Override
    public void dealDamage(Npc npc) {
        System.out.println("Mage deals damage with fireball");
        npc.setHealth(npc.getHealth() - 30);
    }

}
