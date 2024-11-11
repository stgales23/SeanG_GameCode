package Game;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    static ArrayList<Item> inventory = new ArrayList<Item>();

    public static void main(String[] args) {
        runGame();
    }
    public static void runGame() {
        Room currentRoom = World.buildWorld();
        Scanner input = new Scanner(System.in);
        String command;

        do {
            System.out.println(currentRoom);
            System.out.print("What do you want to do? ");
            command = input.nextLine();
            String[] words = command.split(" ");

            String action = words[0]; 
            String itemName = (words.length > 1) ? words[1] : "";

            switch(command) {
                case "e":
                case "w":
                case "n":
                case "s":
                case "u":
                case "d":
                    currentRoom = currentRoom.getExit(action.charAt(0));
                    break;
                case "x":
                    System.out.println("Thanks for walking through my game.");
                    break;
                case "take":
                    if (!itemName.isEmpty()) {
                        Item itemToTake = currentRoom.getItem(itemName);
                        if (itemToTake != null) { 
                            inventory.add(itemToTake);
                            currentRoom.removeItem(itemName); 
                            System.out.println(itemName + " has been added to your inventory.");
                        } else {
                            System.out.println("No such item in the room.");
                        }
                        Item itemInInventory = getItemFromInventory(itemName); // Check inventory
                    } else {
                        System.out.println("Please specify an item to take.");
                    }
                    break;
                case "look":
                    if (!itemName.isEmpty()) {
                        Item itemToLookAt = currentRoom.getItem(itemName);
                        if (itemToLookAt != null) {
                            System.out.println(itemToLookAt.getDescription());
                        } else {
                            Item itemInInventory = getItemFromInventory(itemName); 
                            if (itemInInventory != null) {
                                System.out.println(itemInInventory.getDescription());
                            } else {
                                System.out.println("No such item found.");
                            }
                        }
                    } else {
                        System.out.println("Please specify an item to look at.");
                    }
                    break;
                case "i":
                    if (inventory.size() == 0) {
                        System.out.println("Inventory empty");
                    } else {
                        System.out.println("Inventory contains:");
                        for (Item i : inventory) {
                            System.out.println(i.getName()); 
                        }
                    }
                    break;
                default:
                    System.out.println("I don't understand.");
            }
        } while (!command.equals("x"));
        input.close();
    }

    private static Item getItemFromInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) { 
                return item; 
            }
        }
        return null; 
    }
}
