package HomeTask.task10.TankGame.Tanks;

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

}
