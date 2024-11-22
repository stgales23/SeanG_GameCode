package Game;

public class Comb extends Item {
    
    public Comb(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        Game.print("You use the comb to comb through the area. You find a hidden compartment with a hidden key");
        Item hiddenKey = new Key("Hidden Key", "A key that opens a secret door.");
        Game.inventory.add(hiddenKey);
        Game.print("You've added the hidden key to your inventory.");
    }
}
