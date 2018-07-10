package playground.rpg.model;

public abstract class Npc {

    String name;
    private int health;
    private int mana;
    private int level;
    private Location location;

    public Npc(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.level = 1;
    }

    public abstract void dealDamage(Npc npc);

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
