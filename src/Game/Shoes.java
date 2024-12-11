package Game;

public class Shoes extends Item {
    
    public Shoes(String name, String de) {
        super(name, de);
    }

    @Override
    public void use() {
        Game.print("You put on your shoes and check under the couch cushions.");
        Item key = new Item("keys", "Your car keys! Finally!");
        Game.inventory.add(key);
        Game.print("You’ve found your car keys!");
    }
}
