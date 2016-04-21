import java.util.LinkedList;

import processing.core.*;


public class behavior extends PApplet {

	Character player1, monster;
	Map world;
	BehaviorTreeMonster btm;
	PImage photo;
	
	float previousTime, newTime;

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		
		player1 = new Character(200, 200, 3, (float) .2, this);
		monster = new Character(600, 200, 0, (float) .08, this);
		photo = loadImage("hammer.jpg");
		photo.resize(40, 40);
		LinkedList<Character> characters = new LinkedList<Character>();
		characters.add(player1);
		characters.add(monster);

		previousTime = millis();
		world = new Map( this, characters );
		btm = new BehaviorTreeMonster( this, world );
	}


	public void draw() {
		
		
		


		newTime = millis();

		background(25,25,75);
		
		fill(100,100,100);
		player1.drawCharacter();

		fill(150, 0, 0);
		monster.drawCharacter();
		
		fill(100,50,0);
		world.drawMap();
		
		if(!world.characters.getLast().nikesOn){
			image(photo, 600, 600);
		}
		
		btm.execute( (float)previousTime - newTime, world);

		previousTime = newTime;
		
		
		
		if( world.playerEaten ){

			System.out.println("Monster wins!");
			world.reset();

			
		}
		
        if( world.playerwins ) {
			
			System.out.println("Monster didnt get his tool to break the door. Player wins!");
			world.reset();

		}
	
		

	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "behavior" });
	}


}
