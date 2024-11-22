package Game;

public class JewelBox extends Item {
    
    public JewelBox(String name, String description) {
        super(name, description);
    }

    @Override
    public void open() {
        Item key = Game.getItemFromInventory("Old Key"); 

        if (key != null) {
            Game.print("You use the Old Key to open the jewel box and find a beautiful diamond inside!");
            Item diamond = new Item("diamond", "A shiny, valuable diamond.");
            Game.inventory.add(diamond);
            Game.print("You've added the diamond to your inventory.");
        } else {
            Game.print("The jewel box is locked. You need a key to open it.");
        }
    }
}
