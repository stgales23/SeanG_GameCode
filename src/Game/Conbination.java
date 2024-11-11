package Game;

public class Conbination extends Item {

    public Conbination(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        Game.print("If you find a safe, try opening it!");
    }
}


