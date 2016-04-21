

import processing.core.PApplet;

public class Eat extends ActionNode {

	private Character monster;
	PApplet parent;
	
	public Eat ( Character monster, Character agent, PApplet parent ) {
		this.monster = monster;

		this.parent = parent;
	}
	
	
	public void resetMonster(){
		//Reset monster to the middle of the screen, and without his chompers
		monster.position.x = 400;
		monster.position.y = 400;
		monster.chompers = false;
		
	}
	
	@Override
	protected Steering getAction() {
		Steering steering  = new Steering();
		resetMonster();
		return steering;
	}
}
