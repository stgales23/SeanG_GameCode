package Game;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static ArrayList<Item> inventory = new ArrayList<Item>();
    public static Room currentRoom = World.buildWorld();

    public static void main(String[] args) {
        runGame();
    }

    public static Room getRoom() {
        return currentRoom;
    }

    public static void print(Object obj) {
        System.out.println(obj.toString());
    }

    public static void runGame() {
        Scanner input = new Scanner(System.in);
        String command;

        do {
            System.out.println(currentRoom);
            System.out.print("Which Direction? ");
            command = input.nextLine();
            String[] words = command.split(" ");

            switch (words[0]) {
                case "e":
                case "w":
                case "n":
                case "s":
                case "u":
                case "d":
                    currentRoom = currentRoom.getExit(words[0].charAt(0));
                    break;
                case "x":
                    System.out.println("Thanks for walking through my game.");
                    break;
                case "take":
                    if (words.length < 2) {
                        System.out.println("Take what?");
                    } else {
                        String itemName = words[1];
                        Item item = currentRoom.getItem(itemName);
                        if (item != null) {
                            inventory.add(item);
                            currentRoom.removeItem(itemName);
                            System.out.println(itemName + " added to inventory.");
                        } else {
                            System.out.println("No such item to take.");
                        }
                    }
                    break;
                case "look":
                    if (words.length < 2) {
                        System.out.println("Look at what?");
                    } else {
                        String itemName = words[1];
                        Item item = getItemFromInventory(itemName);
                        if (item != null) {
                            System.out.println(item.getDescription());
                        } else if (currentRoom.getItem(itemName) != null) {
                            System.out.println(currentRoom.getItem(itemName).getDescription());
                        } else {
                            System.out.println("No such item to look at.");
                        }
                    }
                    break;
                case "i":
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory empty");
                    } else {
                        for (Item i : inventory) {
                            System.out.println(i);
                        }
                    }
                    break;
                case "use":
                    if (words.length < 2) {
                        System.out.println("Use what?");
                    } else {
                        String itemName = words[1];
                        Item item = getItemFromInventory(itemName);
                        if (item == null) {
                            item = currentRoom.getItem(itemName);
                        }
                        if (item != null) {
                            item.use();
                        } else {
                            System.out.println("No such item to use.");
                        }
                    }
                    break;
                case "open":
                    if (words.length < 2) {
                        System.out.println("Open what?");
                    } else {
                        String itemName = words[1];
                        Item item = getItemFromInventory(itemName);
                        if (item == null) {
                            item = currentRoom.getItem(itemName);
                        }
                        if (item != null) {
                            item.open();
                        } else {
                            System.out.println("No such item to open.");
                        }
                    }
                    break;
                default:
                    System.out.println("I don't understand.");
            }
        } while (!command.equals("x"));
        input.close();
    }
    public static Item getItemFromInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}






