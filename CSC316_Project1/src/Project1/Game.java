package Project1;

import java.util.InputMismatchException;

/**
 * Main method to initiate the condition of game and start playing
 * 
 * @author Aoyi Li
 *
 */
public class Game {
	/** main method */
	public static void main(String[] args) {
		WorldState state = new WorldState();
		state.addCharacter(new Character("Wumpus", 0, 0));
		state.addCharacter(new Character("Player", 10, 0));
		WumpusDT wumpusTree = new WumpusDT(state);
		System.out.println(wumpusTree.getAction());
	}
}
