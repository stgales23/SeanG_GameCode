package Game;

public class Sister extends NPC {
    public Sister() {
        super("sister", "Your playful sister, always ready to prank you.");
    }

    @Override
    public void talk() {
        say("Why are you looking for the keys? Maybe I know where they are...");
        String[] options = {
            "Where are the keys?",
            "Stop messing with me!"
        };
        getResponse(options);
    }

    @Override
    public void response(int option) {
        switch (option) {
            case 1:
                say("Well, maybe I put them under the couch cushions... maybe.");
                break;
            case 2:
                say("Haha, you’re so serious! I’m not telling you anything.");
                break;
            default:
                say("Don’t take everything so seriously!");
                break;
        }
    }
}
