
public enum Status {
	FORWARD("forward", 10),
	FIRE("fire", 4),
	JUMP("jump", 8),
	DIE("die", 7);
	
	private String name;
	private int count;
	
	private Status(String s, int c){
		name = s;
		count = c;
	}
	public String getName() {
		return name;
	}
	
	public int getCount() {
		return count;
	}
}
