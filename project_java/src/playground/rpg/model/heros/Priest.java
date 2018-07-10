package playground.rpg.model.heros;

import playground.rpg.model.Npc;

public class Priest extends Hero {
    public Priest(String name, int health, int mana) {
        super(name, health, mana);
    }

    @Override
    public void dealDamage(Npc npc) {
        System.out.println("Priest deals damage with a staff");
        npc.setHealth(npc.getHealth() - 10);
    }
}
