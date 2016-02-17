package HomeTask.task3.tanks;

import HomeTask.task3.objectsOnField.BattleField;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp();

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();

    void setX(int x);

    void setY(int y);
	
	public Direction getDirection();
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();

    void create();

    void turn(Direction direction);

    public void destroyOpponent(Tank opponent, BattleField battleField);

}
