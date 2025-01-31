import java.util.HashMap;
import java.util.Map;

public class WeaponDatabase {
    private static final Map<String, Weapon> weapons = new HashMap<>();

    static {
        
        weapons.put("Classic", new Weapon("Classic", 78, 6.75, 12, 0)); 
        weapons.put("Shorty", new Weapon("Shorty", 36, 3.3, 2, 300));
        weapons.put("Frenzy", new Weapon("Frenzy", 78, 10.0, 13, 450));
        weapons.put("Ghost", new Weapon("Ghost", 105, 6.75, 15, 500));
        weapons.put("Sheriff", new Weapon("Sheriff", 159, 4.0, 6, 800));

        
        weapons.put("Stinger", new Weapon("Stinger", 67, 18.0, 20, 1100));
        weapons.put("Spectre", new Weapon("Spectre", 78, 13.33, 30, 1600));

        
        weapons.put("Bucky", new Weapon("Bucky", 44, 1.1, 5, 850));
        weapons.put("Judge", new Weapon("Judge", 34, 3.5, 7, 1850));

        
        weapons.put("Bulldog", new Weapon("Bulldog", 116, 9.15, 24, 2050));
        weapons.put("Guardian", new Weapon("Guardian", 195, 6.5, 12, 2250));
        weapons.put("Phantom", new Weapon("Phantom", 140, 11.0, 30, 2900));
        weapons.put("Vandal", new Weapon("Vandal", 160, 9.25, 25, 2900));

        
        weapons.put("Marshal", new Weapon("Marshal", 202, 1.5, 5, 950));
        weapons.put("Operator", new Weapon("Operator", 255, 0.75, 5, 4700));

        
        weapons.put("Ares", new Weapon("Ares", 72, 10.0, 50, 1600));
        weapons.put("Odin", new Weapon("Odin", 95, 12.0, 100, 3200));

        
        weapons.put("Knife", new Weapon("Knife", 50, 1.0, 1, 0)); 
    }

    public static Weapon getWeapon(String name) {
        return weapons.get(name);
    }

    public static String[] getWeaponNames() {
        return weapons.keySet().toArray(new String[0]);
    }
}
