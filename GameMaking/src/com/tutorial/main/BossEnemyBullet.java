package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemyBullet extends GameObject {

	Random r;
	private Handler handler;
	
	public BossEnemyBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		r = new Random();

		velX = r.nextInt(8 - -8) + -8;
		velY = 8;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		//if(y <= 0 || y>= Game.HEIGHT - 48) velY *= -1;
		//if(x <= 0 || x>= Game.WIDTH - 32) velX *= -1;
		
		if (y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.pink, 16, 16, 0.03f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect( (int) x, (int) y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle( (int) x, (int) y, 16, 16);
	}
	
}

