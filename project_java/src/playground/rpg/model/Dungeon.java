package playground.rpg.model;

public class Dungeon extends Location {

    private Monster[] monsters;
    private Boss boss;

    private static int numberOfDungeons;

    private Dungeon(Monster[] monsters, Boss boss) {
        this.monsters = monsters;
        this.boss = boss;
        numberOfDungeons++;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public static Dungeon createDungeon(Monster[] monsters, Boss boss) {
        if (numberOfDungeons < 100) {
            Dungeon dungeon = new Dungeon(monsters, boss);

            for (int i = 0; i < monsters.length; i++) {
                monsters[i].setLocation(dungeon);
            }
            boss.setLocation(dungeon);

            return dungeon;
        } else {
            return null;
        }
    }

}
