package Game;

public class Broom extends Item {
    
    public Broom(String name, String de) {
        super(name, de);
    }

    @Override
    public void use() {
        Game.print("You use the broom to sweep some dust off the high shelf. There’s a key up there!");
        Item key = new Item("key", "A key that you can use to open the garage.");
        Game.inventory.add(key);
        Game.print("You’ve added the key to your inventory.");
    }
}
