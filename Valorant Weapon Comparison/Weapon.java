public class Weapon {
    private String name;
    private int damage;
    private double fireRate;
    private int magazineSize;
    private int cost;

    public Weapon(String name, int damage, double fireRate, int magazineSize, int cost) {
        this.name = name;
        this.damage = damage;
        this.fireRate = fireRate;
        this.magazineSize = magazineSize;
        this.cost = cost;
    }

    public String getName() { return name; }
    public int getDamage() { return damage; }
    public double getFireRate() { return fireRate; }
    public int getMagazineSize() { return magazineSize; }
    public int getCost() { return cost; }
}
