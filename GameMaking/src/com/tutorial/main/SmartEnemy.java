package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class SmartEnemy extends GameObject {

	Random r;
	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		r = new Random();
		
		for (int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}

		velX = 5;
		velY = 5;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX()-8;
		float diffY = y - player.getY()-8;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		velX = (float) ((-1.0/distance) * diffX *2);
		velY = (float) ((-1.0/distance) * diffY *2);
		
		if(y <= 0 || y>= Game.HEIGHT - 48) velY *= -1;
		if(x <= 0 || x>= Game.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.03f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
}


