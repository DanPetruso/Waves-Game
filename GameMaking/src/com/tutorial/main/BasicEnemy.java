package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject {

	Random r;
	private Handler handler;
	
	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		r = new Random();

		velX = 5;
		velY = 5;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y>= Game.HEIGHT - 48) velY *= -1;
		if(x <= 0 || x>= Game.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.03f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect( (int) x, (int) y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle( (int) x, (int) y, 16, 16);
	}
	
}


