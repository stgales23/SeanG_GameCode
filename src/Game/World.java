package Game;

public class World {
    public static Room buildWorld() {
        Room livingRoom = new Room("livingRoom");
        Room kitchen = new Room("kitchen");
        Room bedroom = new Room("bedroom");
        Room bathroom = new Room("bathroom");
        Room garage = new Room("garage");
        Room hallway = new Room("hallway");
        Room attic = new Room("attic");

        livingRoom.addExit(hallway, 'e');
        hallway.addExit(livingRoom, 'w');
        hallway.addExit(kitchen, 'n');
        hallway.addExit(bedroom, 's');
        hallway.addExit(bathroom, 'e');
        hallway.addExit(garage, 'u');
        hallway.addExit(attic, 'd');

        // Items in the rooms
        Item wallet = new Wallet("wallet", "A wallet with a few cards and a note inside.");
        Item shoes = new Shoes("shoes", "A pair of sneakers.");
        Item broom = new Broom("broom", "A broom to sweep up dust.");
        Item key = new Item("key", "A key that fits your garage door.");
        Item fruitBowl = new Item("fruit bowl", "A bowl filled with fresh fruit.");
        
        livingRoom.addItem(wallet);
        bedroom.addItem(shoes);
        kitchen.addItem(fruitBowl);
        hallway.addItem(broom);

        // NPCs in rooms
        Mom mom = new Mom();
        Sister sister = new Sister();
        Cat cat = new Cat();

        livingRoom.addNPC(mom);
        bedroom.addNPC(sister);
        hallway.addNPC(cat);

        return livingRoom;
    }
}
