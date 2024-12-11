package Game;

import java.util.HashMap;

public class Room {
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private HashMap<String, Item> items = new HashMap<>();
    private HashMap<String, NPC> npcs = new HashMap<>(); // Added for NPCs
    private boolean lock = false;
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public Room getExit(char direction) {
        switch (direction) {
            case 'e': return east;
            case 'w': return west;
            case 'n': return north;
            case 's': return south;
            case 'u': return up;
            case 'd': return down;
            default: return null;
        }
    }

    public void addExit(Room room, char direction) {
        switch (direction) {
            case 'e': east = room; break;
            case 'w': west = room; break;
            case 'n': north = room; break;
            case 's': south = room; break;
            case 'u': up = room; break;
            case 'd': down = room; break;
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

    public void addNPC(NPC npc) { // Added method to add NPCs
        npcs.put(npc.getName(), npc);
    }

    public NPC getNPC(String npcName) { // Added method to get NPCs
        return npcs.get(npcName);
    }

    public NPC removeNPC(String npcName) { // Added method to remove NPCs
        return npcs.remove(npcName);
    }

    public String getDescription() {
        return Game.roomDescription.get(name);
    }
}

