
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import processing.core.*;


public class behavior extends PApplet {

	Character player1, monster;
	Map world;
	BehaviorTreeMonster btm;
	PImage photo;
	BufferedWriter writer;
	FileWriter fw;
	ID3 id3;

	File file;
	
	float previousTime, newTime;

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		
		player1 = new Character(200, 200, 3, (float) .2, this);
		monster = new Character(700, 300, 0, (float) .08, this);
		photo = loadImage("hammer.jpg");
		photo.resize(40, 40);
		LinkedList<Character> characters = new LinkedList<Character>();
		characters.add(player1);
		characters.add(monster);

		previousTime = millis();
		world = new Map( this, characters );
		
		
		File file = new File("file.txt");
		id3 = new ID3(file);
		try {
			 fw = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer = new BufferedWriter(fw);
		

		btm = new BehaviorTreeMonster( this, world,  writer );

		
		System.out.println("Nikes on? | see Nikes? | See Door? | Near Door? | Door Locked? | Door Open? | Action Taken");
	
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

			System.out.println("Monster Wins!");
			world.reset();
			id3.readFile();
			System.exit(0);

			
		}
		
        if( world.playerwins ) {
        	
        	System.out.println("Player Wins!");
			world.reset();
			id3.readFile();
        	System.exit(0);
		}
	
		

	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "behavior" });
	}


}
