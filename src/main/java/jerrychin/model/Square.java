package jerrychin.model;

public class Square {
	private int id;

	public Square(int id) {
		this.id = id;
	}
	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}
}
