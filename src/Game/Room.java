package Game;
import java.util.HashMap;

public class Room {

	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private HashMap<String, Item> items;
	private boolean lock = false;
	private String name;
	
	public Room(String describe, String name) {
		description = describe;
		this.name= name;

		items=new HashMap<>();
	}
	 public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public boolean getLock() {
	        return lock;
	    }
	    public void setLock(boolean lock) {
	        this.lock = lock;
	    }
	
	public Room getExit(char direct) {
		if (direct == 'e') {
			return east;
		} else if (direct == 'w') {
			return west;
		} else if (direct == 'n') {
			return north;
		} else if (direct == 's') {
			return south;
		} else if (direct == 'u') {
			return up;
		} else if (direct == 'd') {
			return down;
		} else {
			return null;
		}
	}
	public void addExit(Room robject, char direct) {
		if (direct == 'e') {
			robject = east;
		} else if (direct == 'w') {
			robject = west;
		} else if (direct == 'n') {
			robject = north;
		} else if (direct == 's') {
			robject = south;
		} else if (direct == 'u') {
			robject = up;
		} else if (direct == 'd') {
			robject = down;
		} else {
			robject = null;
		}
	}

	 public void addItem(Item item) {
	        items.put(item.getName(), item);
	 	}
	    public Item getItem(String itemName) {
	        return items.get(itemName); 
	    }
	    public Item removeItem(String itemName) {
	        return items.remove(itemName); 
	    }
	    public String onString() {
	        return description;
	    }
	}

