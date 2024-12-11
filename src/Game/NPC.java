package Game;

import javax.swing.JOptionPane;

public class NPC {
    private String name;
    private String desc;

    public NPC(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void say(String dialog) {
        Game.print(name + ": " + dialog);
    }

    public void talk() {
        Game.print("You talk to " + name + ".");
        String[] options = {"Ask about the weather", "Ask for directions"};
        getResponse(options);
    }

    public void getResponse(String[] options) {
        String s = "";
        for (int i = 0; i < options.length; i++) {
            s += "Option " + (i + 1) + ": " + options[i] + "\n";
        }
        s += "Enter an option (1-" + options.length + "):";
        
        String input = JOptionPane.showInputDialog(null, s, "Choose an option", JOptionPane.QUESTION_MESSAGE);
        
        if (input != null) {
            try {
                int option = Integer.parseInt(input);
                response(option);
            } catch (NumberFormatException e) {
                Game.print("Invalid input. Please enter a valid number.");
            }
        } else {
            Game.print("No option selected.");
        }
    }

    public void response(int option) {
        switch (option) {
            case 1:
                say("The weather is sunny and nice today.");
                break;
            case 2:
                say("Go north to reach the city.");
                break;
            default:
                say("I don't understand that response.");
                break;
        }
    }
}

