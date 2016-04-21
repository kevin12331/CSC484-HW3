import processing.core.*;

public class behavior extends PApplet {

	Character player1, monster;
	DecisionTree decisionTree;
	PImage photo;
	
	float previousTime, newTime;

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		
		player1 = new Character(200, 200, 3, (float) .2, this);
		monster = new Character(400, 400, 0, (float) .08, this);
		photo = loadImage("billy_vampire.jpg");
		photo.resize(30, 30);
		decisionTree = new DecisionTree( player1, monster, this );
		previousTime = millis();
	}


	public void draw() {
		newTime = millis();

		background(0);
		
		fill(255);
		player1.drawCharacter();

		fill(150, 0, 0);
		monster.drawCharacter();
		
		if(!monster.chompers)
			image(photo, 700,700);

		Steering steeringMons = decisionTree.getAction();
		monster.update(steeringMons, previousTime - newTime);
		
		previousTime = newTime;
		

	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "behavior" });
	}

}
