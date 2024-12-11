package Game;

public class Wallet extends Item {
    
    public Wallet(String name, String de) {
        super(name, de);
    }

    @Override
    public void use() {
        Game.print("You open the wallet and find a note with a clue: 'The keys are in the kitchen, under the fruit bowl.'");
        Item note = new Item("note", "A note with a clue about where to find your keys.");
        Game.inventory.add(note);
        Game.print("You've added the note to your inventory.");
    }
}
