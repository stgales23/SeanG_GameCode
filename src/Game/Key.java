package Game;

public class Key extends Item {
    
    public Key(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        Room currentRoom = Game.getRoom(); 

        if (currentRoom.getLock()) { 
            currentRoom.setLock(false); 
            Game.print("You used the " + getName() + " to unlock the room.");
        } else {
            Game.print("This room is already unlocked.");
        }
    }
}
