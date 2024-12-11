package Game;

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
        for (int i = 0; i < options.length; i++) {
            Game.print("Option " + (i + 1) + ": " + options[i]);
        }
        Game.print("Enter an option (1-" + options.length + "):");
        int option = Game.scan.nextInt();  
        
   
        response(option);
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
