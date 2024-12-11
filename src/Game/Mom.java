package Game;

public class Mom extends NPC {
    public Mom() {
        super("mom", "Your caring mom, always giving you advice.");
    }

    @Override
    public void talk() {
        say("Have you checked the kitchen for your keys? Maybe they are on the counter.");
        String[] options = {
            "I’ll go check, thanks!",
            "I don't need help!"
        };
        getResponse(options);
    }

    @Override
    public void response(int option) {
        switch (option) {
            case 1:
                say("Good luck, and don’t forget to check the fridge too.");
                break;
            case 2:
                say("Well, don't blame me if you can't find them!");
                break;
            default:
                say("I’m just here to help!");
                break;
        }
    }
}
