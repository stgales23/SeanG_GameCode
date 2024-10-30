package Game;

public class Item {

	private String name;
	private String de;

	public Item(String n, String d) {
		name = n;
		de = d;
	}
	public void setN(String n) {
		name = n;
	}

	public void setD(String d) {
		de = d;
	}
	public String getName() {
        return name;
	}   
    public String getDescription() {
	  return de;
    }
	public String toString() {
		return name; 
    }
}
   