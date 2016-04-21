package Project1;

/**
 * Character Object
 * 
 * @author Aoyi Li
 *
 */
public class Character {
	/** name */
	private String Name;
	/** x-coordinator */
	private int X;
	/** y-coordinator */
	private int Y;

	/** constructor of Character object */
	Character(String name, int x, int y) {
		this.Name = name;
		this.X = x;
		this.Y = y;
	}

	/** get x-coordinator */
	int getX() {
		return X;
	}

	/** set x-coordinator */
	void setX(int x) {
		this.X = x;
	}

	/** get y-coordinator */
	int getY() {
		return Y;
	}

	/** set x-coordinator */
	void setY(int y) {
		this.Y = y;
	}

	/** get Character's name */
	String getName() {
		return Name;
	}

	/** set Character's name */
	void setName(String name) {
		this.Name = name;
	}
}
