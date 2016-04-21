package Project1;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * WolrdState Object which describe the game environment
 * 
 * @author Aoyi Li
 *
 */
public class WorldState {
	/** Array of Characters in the game environment */
	private ArrayList<Character> Characters;

	/** Constructor */
	WorldState() {
		this.Characters = new ArrayList<Character>();
	}

	/**
	 * return Character in the game based on the input String, if there's no
	 * match of it return null
	 */
	Character getCharacter(String name) {
		if (this.Characters.isEmpty()) {
			return null;
		}
		// traversal the Character array of the game environment
		for (int i = 0; i < this.Characters.size(); i++) {
			if (this.Characters.get(i).getName() == name) {
				return this.Characters.get(i);
			}
		}
		return null;

	}

	/** add an Character to the game environment */
	void addCharacter(Character character) {
		this.Characters.add(character);

	}
}
