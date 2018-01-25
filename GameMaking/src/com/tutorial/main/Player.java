package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;
	Color playerColor;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}
	
	public Rectangle getBounds() {
		return new Rectangle( (int) x, (int) y, 32, 32);
	}
	
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 45);
		y = Game.clamp(y, 0, Game.HEIGHT - 70);
		
		playerColor = Color.blue;
		
		collision();
		handler.addObject(new Trail((float)x, (float)y, ID.Trail, playerColor, 32, 32, 0.1f, handler));
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH-=1.5;
					playerColor = Color.white;
				}
			}
			
			if(tempObject.getId() == ID.SmartEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH-=1;
					playerColor = Color.white;
				}
			}
			
			if(tempObject.getId() == ID.BossEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH-=5;
					playerColor = Color.white;
				}
			}
		}
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect( (int) x, (int) y, 32, 32);
	}

}
