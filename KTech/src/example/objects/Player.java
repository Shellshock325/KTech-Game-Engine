package example.objects;

import java.awt.event.KeyEvent;

import KTech.components.*;
import KTech.core.KTech;
import KTech.core.Renderer;
import KTech.graphics.Image;
import example.states.ExampleState;



public class Player extends Entity {

	int x, y; //Players x and y coordinates
	
	int mousex = 0, mousey = 0;
	
	Image guy = new Image("/enemy.png");
	Button button;// you need one of these for every button that you want to have   
	Timer timer;
	
	public Player(int x, int y) { // Constructor takes in values of coordinates to spawn at
		this.x = x;
		this.y = y;
		//button = new Button(x , y ,length of button, height of button , text , position of text x, position of text y , color of button, color of text);
		button = new Button(10, 10, 50, 50, "this is a button ", 15, 25, 0xfffffff, 0x24E040);
		timer = new Timer(10);
		ExampleState.manager.addEntity(button);// this is needed to allow the button to function 
		ExampleState.manager.addEntity(timer);
		
	

	}
	
	@Override
	public void update(KTech kt, float time) { 
		if (button.isPressed()) {
			kt.debugOutput("pressed");
		}
		
		if (kt.getInput().isKeyHeld(KeyEvent.VK_UP)) {
			y--;
		}
		
		if (timer.isComplete())
			kt.debugOutput("it has been 10 seconds since you launched the game");
	}

	@Override
	public void render(KTech kt, Renderer r) {
		r.drawImage(guy, x, y); // rendering image at x and y coordinates
	}

	@Override
	public void componentEvent(String name, Entity object) {
		
	}

	@Override
	public void dispose() {
		
	}
}
