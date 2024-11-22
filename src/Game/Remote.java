package Game;

public class Remote extends Item {

    public Remote(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        Game.print("You press a few buttons on the old remote.");
        Game.print("It doesn't seem to control anything in this room, but you feel a bit nostalgic.");
        Game.print("Maybe it could be useful for something later.");
    }
}
