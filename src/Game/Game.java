package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Game {
    private static GameGUI gui;
    public static ArrayList<Item> inventory = new ArrayList<Item>();
    public static HashMap<String, String> roomDescription = new HashMap<String, String>();
    public static Room currentRoom = World.buildWorld();
    public static Scanner scan = new Scanner(System.in);  // Initialize scan here

    public static void main(String[] args) {
        ReadTextFile();
        gui = new GameGUI();
        print(currentRoom);
    }

    public static void print(Object obj) {
        gui.print(obj.toString());
    }

    public static void processCommand(String command) {
        String[] words = command.split(" ");
        StringBuilder output = new StringBuilder();

        switch (words[0].toLowerCase()) {
            case "e":
            case "w":
            case "n":
            case "s":
            case "u":
            case "d":
                handleMovement(words[0].charAt(0), output);
                break;

            case "x":
                output.append("Thanks for playing the game.\n");
                break;

            case "take":
                handleTake(words, output);
                break;

            case "look":
                handleLook(words, output);
                break;

            case "i":
                handleInventory(output);
                break;

            case "use":
                handleUse(words, output);
                break;

            case "open":
                handleOpen(words, output);
                break;

            case "talk":
                handleTalk(words, output);  // Handle NPC talk here
                break;
                
            default:
                output.append("I don't understand that command.\n");
                break;
        }

        print(output.toString());
    }

    private static void handleTalk(String[] words, StringBuilder output) {
        if (words.length < 2) {
            output.append("Talk to whom?\n");
        } else {
            String npcName = words[1];
            NPC npc = currentRoom.getNPC(npcName);  // Get the NPC from the current room
            if (npc != null) {
                npc.talk();  // NPC interaction
            } else {
                output.append("No such NPC to talk to.\n");
            }
        }
    }

    private static void handleMovement(char direction, StringBuilder output) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            output.append("There is no exit in that direction.\n");
        } else if (nextRoom.getLock()) {
            output.append("You cannot enter. The room is locked.\n");
        } else {
            currentRoom = nextRoom;
            output.append("You moved to the " + currentRoom.getName() + ".\n");
        }
    }

    private static void handleTake(String[] words, StringBuilder output) {
        if (words.length < 2) {
            output.append("Take what?\n");
        } else {
            String itemName = words[1];
            Item item = currentRoom.getItem(itemName);
            if (item != null) {
                inventory.add(item);
                currentRoom.removeItem(itemName);
                output.append(itemName + " added to inventory.\n");
            } else {
                output.append("No such item to take.\n");
            }
        }
    }

    private static void handleLook(String[] words, StringBuilder output) {
        if (words.length < 2) {
            output.append("Look at what?\n");
        } else {
            String itemName = words[1];
            Item item = getItemFromInventory(itemName);
            if (item != null) {
                output.append(item.getDescription() + "\n");
            } else if (currentRoom.getItem(itemName) != null) {
                output.append(currentRoom.getItem(itemName).getDescription() + "\n");
            } else {
                output.append("No such item to look at.\n");
            }
        }
    }

    private static void handleInventory(StringBuilder output) {
        if (inventory.isEmpty()) {
            output.append("Inventory empty\n");
        } else {
            for (Item i : inventory) {
                output.append(i + "\n");
            }
        }
    }

    private static void handleUse(String[] words, StringBuilder output) {
        if (words.length < 2) {
            output.append("Use what?\n");
        } else {
            String itemName = words[1];
            Item item = getItemFromInventory(itemName);
            if (item == null) {
                item = currentRoom.getItem(itemName);
            }
            if (item != null) {
                item.use();
                output.append(itemName + " used.\n");
            } else {
                output.append("No such item to use.\n");
            }
        }
    }

    private static void handleOpen(String[] words, StringBuilder output) {
        if (words.length < 2) {
            output.append("Open what?\n");
        } else {
            String itemName = words[1];
            Item item = getItemFromInventory(itemName);
            if (item == null) {
                item = currentRoom.getItem(itemName);
            }
            if (item != null) {
                item.open();
                output.append(itemName + " opened.\n");
            } else {
                output.append("No such item to open.\n");
            }
        }
    }

    public static Item getItemFromInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public static void ReadTextFile() {
        try {
            Scanner input = new Scanner(new File("room_desc"));
            while (input.hasNextLine()) {
                String name = input.nextLine();
                String description = input.nextLine();

                if (!name.equals("#") && !description.equals("#")) {
                    roomDescription.put(name, description);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            print("File not found: room_desc");
        }
    }
}

