package HomeTask.task2.tanks;

import HomeTask.task2.objectsOnField.BattleField;

import java.io.Serializable;

public interface Tank extends Drawable, Destroyable, Serializable {
	
	public Action setUp();

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();
	
	public Direction getDirection();
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();

    public void destroyOpponent(Tank oponent, BattleField battleField);

}
