package Game;

public class Cat extends NPC {
    public Cat() {
        super("cat", "A lazy cat, sitting around or being mischievous.");
    }

    @Override
    public void talk() {
        say("Meow!");
        String[] options = {
            "Pet the cat.",
            "Leave the cat alone."
        };
        getResponse(options);
    }

    @Override
    public void response(int option) {
        switch (option) {
            case 1:
                say("The cat purrs happily.");
                break;
            case 2:
                say("The cat meows loudly as you leave.");
                break;
            default:
                say("The cat ignores you.");
                break;
        }
    }
}
