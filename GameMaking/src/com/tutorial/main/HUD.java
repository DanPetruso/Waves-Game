package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	private float greenValue = 255;
	private float redValue = 255;
	
	public int score = 0;
	public int level = 1;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH,  0, 100);
		greenValue = Game.clamp(greenValue,  0,  255);
		greenValue = HEALTH*2;
		redValue = Game.clamp(redValue, 0, 255);
		redValue = (100-HEALTH)*2;
		
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 20);
		g.setColor(new Color((int)redValue, (int)greenValue, 0));
		g.fillRect( (int) 15, (int) 15, (int) (HEALTH*2), 20);
		g.setColor(Color.white);
		g.drawRect((int)15, (int)15, 200, 20);
		
		g.drawString("Score: " + score, 15, 48);
		g.drawString("Level: " + level, 15, 64);
	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

}
