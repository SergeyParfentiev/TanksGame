package HomeTask.task7.TankGame.Tanks;

import HomeTask.task7.TankGame.ObjectsOnField.BattleField;

import java.util.prefs.BackingStoreException;

public interface Tank extends Drawable, Destroyable {
	
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

    public void agressorDestroyDefender(Tank defender, BattleField battleField);

}
