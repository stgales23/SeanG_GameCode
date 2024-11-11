package Game;

public class Safe extends Item {

    public Safe(String name, String description) {
        super(name, description);
    }

    @Override
    public void open() {
    
        Item conbination = Game.getItemFromInventory("combination");
        if (conbination != null) {
            Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
            
       
            Item diamond = new Item("diamond", "A shiny, valuable diamond.");
            Game.inventory.add(diamond);
        } else {
            Game.print("The safe is locked and you don't have the combination.");
        }
    }
}


