package playground.rpg;

import playground.rpg.model.heros.Hero;
import playground.rpg.model.heros.Mage;
import playground.rpg.model.heros.Priest;
import playground.rpg.model.heros.Warrior;
import playground.rpg.model.Boss;
import playground.rpg.model.Dungeon;
import playground.rpg.model.Monster;
import playground.rpg.model.Player;

/**
 * Design classes for an RPG.
 */
public class RolePlayingGame {

    public static void main(String[] args) {

        // Max - mage
        Player max = new Player(new Mage("Max", 100, 100));

        // Slava - warrior
        Player slava = new Player(new Warrior("Slava", 150, 50));

        // Dima - priest
        Player dima = new Player(new Priest("Dima", 100, 150));


        Monster[] monsters = new Monster[100];
        Boss boss = new Boss("Ragnarok", 10000, 10000);
        Dungeon dungeon = Dungeon.createDungeon(monsters, boss);


        Hero[] heroesInDungeon = new Hero[]{max.getHero(), slava.getHero(), dima.getHero()};
        dungeon.setHeroes(heroesInDungeon);


    }

}
