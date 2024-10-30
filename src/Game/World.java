package Game;

public class World {
	public static Room buildWorld() {
		Room bedroom = new Room("You are in the bed room.");
		Room hallway = new Room("You are in the hallway.");
		Room bathroom = new Room("You are in the bathroom.");
		Room bedroom1 = new Room("You are in guest room.");
		Room downstairs = new Room("You are downstairs.");
		Room attic = new Room("You are in the attic.");
		
		bedroom.addExit(bedroom, 's');
		bedroom.addExit(hallway, 'n');
		
		hallway.addExit(hallway, 'n');
		hallway.addExit(bedroom, 's');
		hallway.addExit(bathroom, 'w');
		hallway.addExit(attic, 'u');
		hallway.addExit(downstairs, 'd');
		hallway.addExit(bedroom1, 'e');
		
		bathroom.addExit(bathroom, 'w');
		bathroom.addExit(hallway, 'e');
		
		bedroom1.addExit(bedroom1, 'e');
		bedroom1.addExit(hallway, 'w');
		
		downstairs.addExit(downstairs, 'd');
		downstairs.addExit(hallway, 'd');
		
		attic.addExit(attic, 'u');
		attic.addExit(hallway, 'd');
			
		
		Item toy = new Item("toy","Haven't seen this in ages");
		Item book = new Item("book","Feels pretty light");
		Item key = new Item("key", "Wonder what this opens") ;
		Item paper = new Item("paper","This is door key ");
		Item towel = new Item("towel","pretty damp");
		
		bedroom.addItem(key);
		bedroom.addItem(toy);
		bedroom.addItem(book);
		bathroom.addItem(paper);
		hallway.addItem(towel);
		
		return bedroom;
		}
	}